package com.camilolopes.core.impl.service;


import java.util.List;

import javax.validation.ConstraintViolationException;

import org.hibernate.HibernateException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.camilolopes.core.dbunit.config.DBUnitConfiguration;
import com.camilolopes.core.dbunit.config.DBUnitHibernateUtil;
import com.camilolopes.core.domain.ebook.Author;
import com.camilolopes.core.interfaces.service.AuthorService;
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthorServiceImplATest extends DBUnitConfiguration {
	@Autowired
	@Qualifier("authorServiceImpl")
	private AuthorService authorServiceImpl;

	@Before
	public void setUp() throws Exception {
		getSetUpOperation().execute(getConnection(), getDataSet());
	}

	@Test
	public void testSaveAuthorWithSucess() {
		Author authorCamilo = creatingAuthor();
		try{
			authorServiceImpl.saveOrUpdate(authorCamilo);
		}catch(Exception e){
			fail("Not Expected Result ");
		}
	}

	@Test
	public void testEmailCannotBeNull() throws Exception {
		Author authorEmailInvalid = getAuthor();
		authorEmailInvalid.setNameEditor("Camilo Lopes");
		try {
			authorServiceImpl.saveOrUpdate(authorEmailInvalid);
			fail("Not expected execution of this line");
		} catch (ConstraintViolationException e) {
			assertTrueFieldAuthorCannotNull(authorEmailInvalid);
		}
	}
	
	@Test
	public void testNameEditorCannotNull() throws Exception{
		Author author = getAuthor();
		author.setEmail("author@xpto.com");
		author.setNameEditor(null);
		try{
			authorServiceImpl.saveOrUpdate(author);
		}catch(ConstraintViolationException e){
			assertTrueFieldAuthorCannotNull(author);
		}
	}

	private void assertTrueFieldAuthorCannotNull(Author author) {
		assertEquals(DBUnitHibernateUtil.getValidatorConstraintsNotNullMessage(),DBUnitHibernateUtil.getViolationMessageFromEntity(author));
	}
	
	@Test
	public void testNameAuthorCannotNull() throws Exception{
		Author author = getAuthor();
		author.setEmail("author@xpto.com");
		author.setNameEditor("camilo lopes");
		try{
			authorServiceImpl.saveOrUpdate(author);
		}catch(ConstraintViolationException e){
			assertTrueFieldAuthorCannotNull(author);
		}
	}
	@Test
	public void testLastNameAuthorCannotNull() throws Exception{
		Author author = getAuthor();
		author.setEmail("author@xpto.com");
		author.setNameEditor("camilo lopes");
		author.setName("camilo lopes");
		try{
			authorServiceImpl.saveOrUpdate(author);
		}catch(ConstraintViolationException e){
			assertTrueFieldAuthorCannotNull(author);
		}
	}
	
	@Test(expected=HibernateException.class)
	public void testEmailAuthorAlreadyExist() throws Exception{
		Author author = creatingAuthor();
		author.setEmail("camilo@xpto.com");
			authorServiceImpl.saveOrUpdate(author);
	}
	
	@Test
	public void testGetAllAuthors() throws Exception {
		List<Author> listAuthors = authorServiceImpl.list();
		assertNotNull(listAuthors);
		assertFalse(listAuthors.isEmpty());
	}

	@Test
	public void testCVCannotbeNull() throws Exception{
		Author populatedAuthor = creatingAuthor();
		populatedAuthor.setCv(null);
		try{
			authorServiceImpl.saveOrUpdate(populatedAuthor);
			fail("Not Expected result");
		}catch(ConstraintViolationException e){
			assertTrueFieldAuthorCannotNull(populatedAuthor);
		}
	}
	
	@Test
	public void testGetAllAuthorOrderAsc() throws Exception {
		List<Author> listAuthors = authorServiceImpl.list();
		assertEquals("Ana Marcela",listAuthors.get(0).getNameEditor());
		
	}

	private Author getAuthor() {
		Author author = new Author();
		return author;
	}
	
	private Author creatingAuthor() {
		Author authorCamilo = new Author();
		authorCamilo.setName("Camilo");
		authorCamilo.setLastname("Lopes");
		authorCamilo.setEmail("camilolopes@xpto.com");
		authorCamilo.setCv("Trabalha desde");
		authorCamilo.setNameEditor("Camilo Lopes");
		authorCamilo.setPhoto("camilo.jpg");
		return authorCamilo;
	}

}
