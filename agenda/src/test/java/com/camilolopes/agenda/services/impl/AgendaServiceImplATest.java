package com.camilolopes.agenda.services.impl;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.camilolopes.agenda.dbunit.config.DBUnitConfiguration;
import com.camilolopes.agenda.interfaces.services.AgendaService;
import com.camilolopes.agenda.model.domain.Agenda;

@RunWith(SpringJUnit4ClassRunner.class)
public class AgendaServiceImplATest extends DBUnitConfiguration {
	@Autowired
	@Qualifier("agendaServiceImpl")
	private AgendaService agendaServiceImpl;

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testSaveContatoWithSuccess() {
		Agenda pateta = new Agenda();
		pateta.setEmail("xpto@handson.com");
		pateta.setName("Pateta");
		pateta.setLastName("Disney");
		pateta.setPhone("1132365");
		agendaServiceImpl.save(pateta);
		assertFalse(agendaServiceImpl.listAll().isEmpty());
	}
	
	@Test
	public void testDeleteContatoWithSucess(){
		Agenda registerCamilo = agendaServiceImpl.find(1L);
		assertNotNull(registerCamilo);
		agendaServiceImpl.delete(registerCamilo);
		assertTrue(agendaServiceImpl.listAll().isEmpty());
	}
	@Test
	public void testUpdateContatoWithSuccess(){
		long id = 1L;
		Agenda registerCamilo = agendaServiceImpl.find(id);
		String lastName = "Neto";
		registerCamilo.setLastName(lastName);
		agendaServiceImpl.update(registerCamilo);
		Agenda registerCamiloUpdated = agendaServiceImpl.find(id);
		assertEquals(lastName,registerCamiloUpdated.getLastName());
	}
	@Test
	public void testGetAllRegisterDataBaseIsNotEmpty(){
		assertFalse(agendaServiceImpl.listAll().isEmpty());
	}

}
