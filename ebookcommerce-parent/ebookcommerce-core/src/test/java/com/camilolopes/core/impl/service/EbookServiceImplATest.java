package com.camilolopes.core.impl.service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.camilolopes.core.dbunit.config.DBUnitConfiguration;
import com.camilolopes.core.dbunit.config.DBUnitHibernateUtil;
import com.camilolopes.core.domain.ebook.Author;
import com.camilolopes.core.domain.ebook.CategoryEbook;
import com.camilolopes.core.domain.ebook.Ebook;
import com.camilolopes.core.domain.ebook.TypeEbook;
import com.camilolopes.core.enums.ebook.Status;
import com.camilolopes.core.exception.EbookException;
import com.camilolopes.core.interfaces.service.AuthorService;
import com.camilolopes.core.interfaces.service.CategoryEbookService;
import com.camilolopes.core.interfaces.service.EbookService;
import com.camilolopes.core.interfaces.service.TypeEbookService;

@RunWith(SpringJUnit4ClassRunner.class)
public class EbookServiceImplATest extends DBUnitConfiguration {
	
	@Autowired
	@Qualifier("ebookServiceImpl")
	private EbookService ebookServiceImpl;
	
	@Autowired
	@Qualifier("typeEbookServiceImpl")
	private TypeEbookService typeEbookServiceImpl;
	
	@Autowired
	@Qualifier("categoryEbookServiceImpl")
	private CategoryEbookService categoryEbookServiceImpl;
	
	@Autowired
	@Qualifier("authorServiceImpl")
	private AuthorService authorServiceImpl;
	
	@Before
	public void setUp() throws Exception {
		getSetUpOperation().execute(getConnection(), getDataSet());
	}

	@Test
	public void testEbookWasSavedWithSuccess() throws Exception {
		Ebook ebook = createEbook();
		ebookServiceImpl.saveOrUpdate(ebook);
		assertNotNull(ebookServiceImpl.getEbookByTitle(ebook.getTitle()));
	}
	
	@Test
	public void testEbookSavedIfAssociatedWithOneAuthor() throws Exception {
		Ebook ebook = ebookServiceImpl.getById(1L);
		assertNotNull(ebook.getAuthors());
		int totalExpectedAuthor = 1;
		assertEquals(totalExpectedAuthor,ebook.getAuthors().size());

	}
	
	@Test
	public void testEbookSavedIfIsAssociatedWithMoreOneAuthor() throws Exception {
		Ebook ebook = ebookServiceImpl.getEbookByTitle("JEE Agile");
		int totalAuthorExpected = 2;
		assertEquals(totalAuthorExpected,ebook.getAuthors().size());

	}
	
	@Test
	public void testEbookMustHaveMinimalOneAuthorAssociated() throws Exception{
		Ebook ebook = createEbook();
		ebook.getAuthors().clear();
		try{
			ebookServiceImpl.saveOrUpdate(ebook);
		} catch(EbookException e) {
			assertEquals(DBUnitHibernateUtil.getValidatorConstraintsNotEmptyMessage(),DBUnitHibernateUtil.getViolationMessageFromEntity(ebook));
		}
	}
	
	@Test
	public void testEbookSavedMustHaveAuthorAssociated() throws Exception {
		List<Ebook> listEbooks = ebookServiceImpl.list();
		for (Ebook ebook : listEbooks) {
			assertNotNull(ebook.getAuthors());
		}
	}
	
	@Test
	public void testEbookSaveWithoutAuthorIsNotPermitted() throws Exception {
		Ebook ebook = createEbook();
		ebook.getAuthors().clear();
		try{
			ebookServiceImpl.saveOrUpdate(ebook);
			fail("Not Expected execution of this line");
		}catch(Exception e){
			assertEquals(DBUnitHibernateUtil.getValidatorConstraintsNotEmptyMessage(),DBUnitHibernateUtil.getViolationMessageFromEntity(ebook));
		}
	}
	
	@Test
	public void testEbookCannotBeToSavedWithoutTypeExpectedException() throws Exception {
		Ebook ebook = createEbook();
		ebook.getTypeEbooks().clear();
		try{
			ebookServiceImpl.saveOrUpdate(ebook);
			fail("Not Expected execution of this line");
		}catch(Exception e){
			assertEquals(DBUnitHibernateUtil.getValidatorConstraintsNotEmptyMessage(),DBUnitHibernateUtil.getViolationMessageFromEntity(ebook));
		}
		
	}
	
	@Test
	public void testEbookCanHaveMoreOneTypeAssociated() throws Exception {
		Ebook ebook = ebookServiceImpl.getById(1L);
		int expectedTotalTypeAssociated = 2;
		int totalSizeAssociated = ebook.getTypeEbooks().size();
		assertEquals(expectedTotalTypeAssociated,totalSizeAssociated);
	}
	
	@Test
	public void testEbookSavingWithMoreOneTypeAssociatedWithSuccess() throws Exception {
		Ebook ebook = createEbook();
		List<TypeEbook> listTypesEbooks = typeEbookServiceImpl.list();
		int firstElement = 0;
		int minimumTypePermitted = 1;
		int secondElement = 1;
		TypeEbook Normal = listTypesEbooks.get(firstElement);
		TypeEbook Promotion = listTypesEbooks.get(secondElement);
		ebook.getTypeEbooks().add(Promotion);
		ebook.getTypeEbooks().add(Normal);
		int totalTypeAssociated = ebook.getTypeEbooks().size();
		assertTrue(totalTypeAssociated > minimumTypePermitted);
	}
	
	@Test(expected=EbookException.class)
	public void testSaveEbookWithTitleAlreadyExistIsNotPermitted() throws Exception{
		Ebook ebookDuplicated = createEbook();
		ebookDuplicated.setTitle("TDD");
		ebookServiceImpl.saveOrUpdate(ebookDuplicated);
	}
	
	@Test
	public void testSearchEbookIsCaseInsensitiveByTitle() throws Exception {
		Ebook ebookByTitle = ebookServiceImpl.getEbookByTitle("jee aGilE");
		assertNotNull(ebookByTitle);
		assertEquals("JEE Agile",ebookByTitle.getTitle());
	}
	
	@Test
	public void testIfEbookIsInactiveItExpectedNull() throws Exception {
		Ebook ebookByTitle = ebookServiceImpl.getEbookByTitle("Guide for SCJP Exam");
		assertNull(ebookByTitle);
	}
	
	@Test
	public void testIfEbookActiveWasUpdatedToInactive() throws Exception{
		long id = 2l;
		Ebook ebookById = ebookServiceImpl.getById(id);
		assertEquals(Status.Active, ebookById.getStatus());
		ebookById.setStatus(Status.Inactive);
		ebookServiceImpl.saveOrUpdate(ebookById);
		assertEquals(Status.Inactive, ebookById.getStatus());
	}
	
	@Test
	public void testIfEbookInactiveWasUpdatedToActive() throws Exception{
		long id = 3l;
		Ebook ebookById = ebookServiceImpl.getById(id);
		assertEquals(Status.Inactive, ebookById.getStatus());
		ebookById.setStatus(Status.Active);
		ebookServiceImpl.saveOrUpdate(ebookById);
		assertEquals(Status.Active, ebookById.getStatus());
	}
	
	@Test
	public void testGetListEbookInactiveIsNotEmpty() throws EbookException{
		assertFalse(ebookServiceImpl.listInactiveEbook().isEmpty());
	}
	
	@Test
	public void testThereAreNotEbookInactive(){
		final long id = 3;
		Ebook ebookInactive;
		try {
			ebookInactive = ebookServiceImpl.getById(id);
			ebookServiceImpl.delete(ebookInactive);
			assertTrue(ebookServiceImpl.listInactiveEbook().isEmpty());
		} catch (Exception e) {
			fail("Not Expected result");
		}
		
	}
	
	@Test
	public void testListEbookInactiveHasOneEbook() throws EbookException{
		final int totalInactiveEbookExpected = 1;
		assertEquals(totalInactiveEbookExpected,ebookServiceImpl.listInactiveEbook().size());
	}

	private Ebook createEbook() throws Exception {
		Ebook ebook = new Ebook("JEE Frameworks", Status.Active, "chapter 1 - overview", "learning jee", BigDecimal.TEN, "coverjee", 2012);
		List<Author> authors = authorServiceImpl.list();
		ebook.setAuthors(new HashSet<Author>(authors));
		List<TypeEbook> typeEbooks = typeEbookServiceImpl.list() ;
		ebook.getTypeEbooks().addAll(typeEbooks);
		ebook.setCover("cover");
		long id = 1L;
		CategoryEbook categoryEbook= categoryEbookServiceImpl.getById(id);
		ebook.setCategoryEbook(categoryEbook);
		
		return ebook;
	}

	public EbookService getEbookService() {
		return ebookServiceImpl;
	}

	public void setEbookService(EbookService ebookService) {
		this.ebookServiceImpl = ebookService;
	}

	public CategoryEbookService getCategoryEbookServiceImpl() {
		return categoryEbookServiceImpl;
	}

	public void setCategoryEbookServiceImpl(CategoryEbookService categoryEbookServiceImpl) {
		this.categoryEbookServiceImpl = categoryEbookServiceImpl;
	}

}