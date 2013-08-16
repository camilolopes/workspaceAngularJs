package com.camilolopes.movie.dbunit.config;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class DBUnitConfigurationTest extends DBUnitConfiguration{
	
	@Before
	public void setUp() throws Exception {
		getSetUpOperation().execute(getConnection(), getDataSet());
	}

	@Test
	public void testConectionDataSet() throws Exception {
		assertNotNull(getDataSet());
	}

}
