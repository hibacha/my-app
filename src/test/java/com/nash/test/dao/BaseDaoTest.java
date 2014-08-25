package com.nash.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

import com.nash.dao.LocationDao;
import com.nash.model.Location;

@ContextConfiguration(locations = { "/context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseDaoTest extends AbstractTestNGSpringContextTests{
	private final static String BASE_VERSION="1.6.0";
	@Autowired
	private LocationDao dao;
	
	@BeforeSuite
	public void testJVMVersion() {
		String version  = System.getProperty("java.version");
		Assert.assertTrue(version.startsWith(BASE_VERSION));
	}

	@BeforeSuite
	public void testDB() {

	}
	@Test
	@Transactional
	public void create(){
		Location loc = new Location();
		loc.setAbbreviation("PEK");
		loc.setAddress("chang an street");
		loc.setCity("Beijing");
		Integer id = dao.create(loc);
//		
//		Location fromDb = dao.read(id);
//		Assert.assertEquals(loc.getAbbreviation(), fromDb.getAbbreviation());
	}
}
