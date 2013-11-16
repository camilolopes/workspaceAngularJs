package com.camilolopes.agenda.interfaces.services;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.camilolopes.agenda.model.domain.Agenda;

public interface AgendaService extends GenericService<Agenda> {
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	Agenda find(long id);


}
