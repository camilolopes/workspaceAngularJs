package com.camilolopes.web.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.camilolopes.core.domain.ebook.TypeEbook;
import com.camilolopes.core.interfaces.service.TypeEbookService;

@Controller
@Path("/type")
public class TypeController {
	@Autowired
	@Qualifier("typeEbookServiceImpl")
	private TypeEbookService typeEbookServiceImpl;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TypeEbook> getList() throws Exception {
		return typeEbookServiceImpl.list();
	}

	public TypeEbookService getTypeEbookServiceImpl() {
		return typeEbookServiceImpl;
	}

	public void setTypeEbookServiceImpl(TypeEbookService typeEbookServiceImpl) {
		this.typeEbookServiceImpl = typeEbookServiceImpl;
	}
}
