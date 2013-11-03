package com.camilolopes.web.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.camilolopes.core.domain.ebook.CategoryEbook;
import com.camilolopes.core.interfaces.service.CategoryEbookService;
@Controller
@Path("/category")
public class CategoryController {
	@Autowired
	@Qualifier("categoryEbookServiceImpl")
	private CategoryEbookService categoryEbookServiceImpl;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CategoryEbook> getList() throws Exception {
		return categoryEbookServiceImpl.list();
	}

	public CategoryEbookService getCategoryEbookServiceImpl() {
		return categoryEbookServiceImpl;
	}

	public void setCategoryEbookServiceImpl(CategoryEbookService categoryEbookServiceImpl) {
		this.categoryEbookServiceImpl = categoryEbookServiceImpl;
	}
	
	
}
