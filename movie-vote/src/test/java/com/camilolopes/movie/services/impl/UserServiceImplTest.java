package com.camilolopes.movie.services.impl;


import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.camilolopes.dbunit.configuration.DBUnitConfiguration;
import com.camilolopes.movie.interfaces.services.UserService;
import com.camilolopes.movie.model.bean.User;
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest extends DBUnitConfiguration {
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userServiceImpl;
	@Before
	public void setUp() throws Exception {
		getSetUpOperation().execute(getConnection(), getDataSet());
	}

	@Test
	public void testSavedUserWithSucess() {
		User user = new User();
		user.setEmail("lopes@camilolopes.com.br");
		user.setName("lopes");
		try{
			userServiceImpl.saveOrUpdate(user);
		}catch(Exception e){
			fail("not expected result");
		}
	}
	@Test(expected=ConstraintViolationException.class)
	public void testSaveUnsuccessNameOfUserIsInvalid(){
		User user = new User();
		user.setEmail("email@teste.com");
		userServiceImpl.saveOrUpdate(user);
	}
	@Test(expected=ConstraintViolationException.class)
	public void testSaveUnsucessEmailCannotNull(){
		User user = new User();
		user.setName("Pateta");
		userServiceImpl.saveOrUpdate(user);
	}
	@Test(expected=ConstraintViolationException.class)
	public void testSaveInvalidNameAndEmailCannotNull(){
		User user = new User();
		userServiceImpl.saveOrUpdate(user);
	}
	@Test(expected=ConstraintViolationException.class)
	public void testSaveUnsuccessEmailFormatIsInvalid(){
		User user = new User();
		user.setName("Patinhas");
		user.setEmail("patinhas@");
		userServiceImpl.saveOrUpdate(user);
	}

}
