package com.camilolopes.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.camilolopes.core.domain.ebook.Ebook;
import com.camilolopes.core.exception.EbookException;
import com.camilolopes.core.exception.enums.EbookMessageResponse;
import com.camilolopes.core.interfaces.service.AuthorService;
import com.camilolopes.core.interfaces.service.EbookService;
import com.camilolopes.web.services.interfaces.EbookImageService;
import com.camilolopes.web.util.AjaxMsg;

@Controller
@Path("/ebook")
public class EbookController {

	@Autowired
	@Qualifier("ebookServiceImpl")
	private EbookService ebookServiceImpl;

	@Autowired
	@Qualifier("authorServiceImpl")
	private AuthorService authorServiceImpl;

	@Autowired
	@Qualifier("ebookImageService")
	private EbookImageService ebookImageService;


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getList() {
		List<Ebook> ebooks = new ArrayList<Ebook>();
		List<AjaxMsg> errors = new ArrayList<AjaxMsg>();
		Response responseStatus = null;
		try {
			ebooks = ebookServiceImpl.list();
		} catch (EbookException e) {
			errors.add(addAjaxMessage(e.getEbookMessageResponse()));
		} catch (Exception e) {
			errors.add(addAjaxMessage(EbookMessageResponse.EBOOK_CANNOT_BE_LISTED));
		}
		finally {

			responseStatus = checkErrors(errors, ebooks);
		}
		return responseStatus;

	}

	@GET
	@Produces("application/image")
	@Path("/image/{imagename}")
	public Response downloadEbookImage(
			@PathParam("imagename") String imagename,
			@Context HttpServletResponse response) {
		try {
			ebookImageService.writeOnResponse(imagename, response);
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.ok().build();
	}


	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response remove(@PathParam("id") Long id) {
		 Response responseStatus = null;
		List<AjaxMsg> errors = new ArrayList<AjaxMsg>();

		try {

			Ebook ebook = ebookServiceImpl.getById(id);
			ebookServiceImpl.delete(ebook);

		} catch (EbookException e) {
			errors.add(new AjaxMsg(e.getEbookMessageResponse()));

		} catch (Exception e) {
			errors.add(addAjaxMessage(EbookMessageResponse.EBOOK_CANNOT_BE_REMOVED));

		} finally {
			if (errors != null && errors.isEmpty() == false) {
				 responseStatus = Response.status(Response.Status.NOT_ACCEPTABLE).entity(errors).build();
				return responseStatus;
			}
			
			AjaxMsg removeSuccess = new AjaxMsg(EbookMessageResponse.EBOOK_REMOVE_SUCCESS);
			responseStatus = Response.status(Response.Status.OK).entity(removeSuccess).build();
		}

		return responseStatus;

	}

	public EbookService getEbookServiceImpl() {
		return ebookServiceImpl;
	}

	public void setEbookServiceImpl(EbookService ebookServiceImpl) {
		this.ebookServiceImpl = ebookServiceImpl;
	}

	public AuthorService getAuthorServiceImpl() {
		return authorServiceImpl;
	}


	private AjaxMsg addAjaxMessage(EbookMessageResponse ebookMessageResponse) {
		return new AjaxMsg(ebookMessageResponse);
	}


	
	public Response checkErrors(List<AjaxMsg> errors,List<Ebook> ebooks){
		Response responseStatus = null;
		if (errors != null && errors.isEmpty() == false) {
			responseStatus = Response.status(Response.Status.NOT_ACCEPTABLE).entity(errors).build();
			return responseStatus;
		}
		responseStatus = Response.status(Response.Status.OK).entity(ebooks)	.build();
		return responseStatus;
	}

}