package com.camilolopes.agenda.impl.dao;

import org.springframework.stereotype.Repository;

import com.camilolopes.agenda.interfaces.dao.AgendaDAO;
import com.camilolopes.agenda.model.domain.Agenda;
@Repository
public class AgendaDAOImpl extends GenericHibernateDAO<Agenda> implements	AgendaDAO {

	public AgendaDAOImpl() {
		super(Agenda.class);
		// TODO Auto-generated constructor stub
	}

}
