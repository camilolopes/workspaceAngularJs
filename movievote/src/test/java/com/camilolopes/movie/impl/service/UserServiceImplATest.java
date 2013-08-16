package com.camilolopes.movie.impl.service;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.camilolopes.movie.dbunit.config.DBUnitConfiguration;
import com.camilolopes.movie.domain.User;
import com.camilolopes.movie.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplATest extends DBUnitConfiguration{
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	@Before
	public void setUp() throws Exception {
		getSetUpOperation().execute(getConnection(), getDataSet());
	}

	@Test
	public void testSaveUserWithSuccess() throws Exception {
		User user = new User();
		user.setEmail("camilo@camilolopes.com");
		user.setName("camilo");
		userService.saveOrUpdate(user);
	}
	@Test(expected=ConstraintViolationException.class)
	public void testUserInvalidDataIsEmpty(){
		userService.saveOrUpdate(new User());
	}

}