package com.camilolopes.agenda.web.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.camilolopes.agenda.interfaces.services.AgendaService;
import com.camilolopes.agenda.model.domain.Agenda;

@Controller
@Path("/agenda")
public class AgendaController {

	@Autowired
	@Qualifier("agendaServiceImpl")
	private AgendaService agendaService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void save(Agenda agenda){
		agendaService.save(agenda);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(Agenda agenda){
		agendaService.delete(agenda);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Agenda agenda){
		agendaService.update(agenda);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Agenda> listAll(){
		
		return agendaService.listAll();
				
	}

	public AgendaService getAgendaService() {
		return agendaService;
	}

	public void setAgendaService(AgendaService agendaService) {
		this.agendaService = agendaService;
	}
}
