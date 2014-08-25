package com.nash.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nash.dao.LocationDao;
import com.nash.model.Location;


public class LocationTest extends BaseDaoTest {

	@Autowired
	private LocationDao dao;
	
	
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
	
	@Test(enabled=false)
	public void read(){
		
		dao.read(94);
	}
}
