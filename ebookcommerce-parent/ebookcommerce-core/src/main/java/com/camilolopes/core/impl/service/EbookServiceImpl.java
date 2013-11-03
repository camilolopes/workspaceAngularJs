package com.camilolopes.core.impl.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.camilolopes.core.domain.ebook.Ebook;
import com.camilolopes.core.exception.EbookException;
import com.camilolopes.core.exception.enums.EbookMessageResponse;
import com.camilolopes.core.interfaces.dao.EBookDAO;
import com.camilolopes.core.interfaces.service.EbookService;

@Service
public class EbookServiceImpl extends GenericServiceImpl<Ebook, EBookDAO> implements EbookService {
	
	private String messageContraintDuplicatedTitle = "integrity constraint violation: unique constraint or index violation; TITLE_ table: EBOOK";
	
	private String messageConstraintStart = "Duplicate entry";
	private String messageConstraintEnd = "for key 'title_UNIQUE'";

	@Autowired
	@Qualifier("ebookDAOImpl")
	@Override
	public void setDao(EBookDAO dao) {
		super.setDao(dao);
	}

	@Override
	public Ebook getEbookByTitle(String title) throws  EbookException{
		Ebook ebookByTitle = getDao().getEbookByTitle(title);
		return ebookByTitle;
	}
	
	@Override
	public List<Ebook> list() throws Exception {
		try {
			return getDao().list();
		} catch (Exception e) {
			throw new EbookException(e, EbookMessageResponse.EBOOK_CANNOT_BE_LISTED);
		}
	}
	
	@Override
	public void saveOrUpdate(Ebook entity) throws Exception {
		try {
			super.saveOrUpdate(entity);
		} catch (DataIntegrityViolationException e) {
			validateEbookTitleDuplicatedException(e);
		} catch (ConstraintViolationException e) {
			validateEbookTitleDuplicatedException(e);
		} catch (RuntimeException e) {
			validateEbookTitleDuplicatedException(e);
		}
	}
	
	@Override
	public void delete(Ebook entity) throws Exception {
		try {
			super.delete(entity);
		} catch (Exception e) {
			throw new EbookException(e, EbookMessageResponse.EBOOK_CANNOT_BE_REMOVED);
		}
	}

	private void validateEbookTitleDuplicatedException(Exception e) throws EbookException {
		if (isEbookTitleDuplicated(e)) {
			throw new EbookException(e, EbookMessageResponse.TITLE_DUPLICATED);
		} else {
			throw new EbookException(e, EbookMessageResponse.ERROR_UNEXPECTED);
		}
	}
	
	private boolean isEbookTitleDuplicated(Exception e) {
		return e.getMessage().equalsIgnoreCase(messageContraintDuplicatedTitle) || (
			e.getMessage().startsWith(messageConstraintStart) && e.getMessage().endsWith(messageConstraintEnd)
		);
	}

	@Override
	public List<Ebook> listInactiveEbook() {
		List<Ebook>listInactiveEbook = getDao().listInactiveEbook();
		return listInactiveEbook;
	}

} 