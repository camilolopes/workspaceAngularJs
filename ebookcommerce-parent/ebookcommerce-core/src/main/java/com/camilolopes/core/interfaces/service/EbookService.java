package com.camilolopes.core.interfaces.service;

import java.util.List;

import com.camilolopes.core.domain.ebook.Ebook;
import com.camilolopes.core.exception.EbookException;

public interface EbookService extends GenericService<Ebook>{

	Ebook getEbookByTitle(String title) throws EbookException;

	List<Ebook> listInactiveEbook() throws EbookException;
	
}