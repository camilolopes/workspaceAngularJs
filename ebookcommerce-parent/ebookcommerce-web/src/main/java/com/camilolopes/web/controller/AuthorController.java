package com.camilolopes.web.controller;

import java.io.FileNotFoundException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.camilolopes.core.domain.ebook.Author;
import com.camilolopes.core.interfaces.service.AuthorService;
import com.camilolopes.web.services.interfaces.AuthorImageService;

@Controller
@Path("/author")
public class AuthorController {

	private static String DEFAULT_PHOTO = "user_undefined.jpg";
	
	@Autowired
	@Qualifier("authorServiceImpl")
	private AuthorService authorServiceImpl;
	
	@Autowired
	@Qualifier("authorImageService")
	private AuthorImageService authorImageService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Author> getList() throws Exception {
		return authorServiceImpl.list();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(Author author) throws Exception {
		String photo = author.getPhoto();
		int size = 0;
		if (photo != null && photo.length() > size) {
			try {
				validatePhoto(photo);
			} catch (FileNotFoundException e) {
				return	Response.status(Response.Status.NOT_FOUND).build();
			}
		} else {
			photo = DEFAULT_PHOTO;
			author.setPhoto(photo);
		}
		authorServiceImpl.saveOrUpdate(author);
		return Response.status(Response.Status.OK).build();
	}
	
	@GET
	@Produces("application/image")
	@Path("/image/{imagename}")
	public Response download(@PathParam("imagename") String imagename, @Context HttpServletResponse response) {
		try {
			authorImageService.writeOnResponse(imagename, response);
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.ok().build();
	}
	
	public void validatePhoto(String photo) throws FileNotFoundException {
		boolean existFile = authorImageService.isExistFile(photo);
		if (existFile==false) {
			throw new FileNotFoundException(photo);
		}
	}
	
	public AuthorService getAuthorServiceImpl() {
		return authorServiceImpl;
	}

	public void setAuthorServiceImpl(AuthorService authorServiceImpl) {
		this.authorServiceImpl = authorServiceImpl;
	}

}
