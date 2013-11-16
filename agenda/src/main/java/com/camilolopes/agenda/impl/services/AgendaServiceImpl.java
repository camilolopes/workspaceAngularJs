package com.camilolopes.agenda.impl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.camilolopes.agenda.interfaces.dao.AgendaDAO;
import com.camilolopes.agenda.interfaces.services.AgendaService;
import com.camilolopes.agenda.interfaces.services.GenericServiceImpl;
import com.camilolopes.agenda.model.domain.Agenda;

@Service
public class AgendaServiceImpl extends GenericServiceImpl<Agenda, AgendaDAO> implements AgendaService{

	@Autowired
	@Qualifier("agendaDAOImpl")
	@Override
	public void setDao(AgendaDAO dao) {
		super.setDao(dao);
	}

	public Agenda find(long id) {
		Agenda agendaRegister = getDao().find(id);
		return agendaRegister;
	}
}
