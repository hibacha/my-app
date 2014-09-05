package com.nash.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nash.model.Location;
import com.nash.service.LocationService;
import com.nash.test.BaseEnvironmentTest;

public class LocationTest extends BaseEnvironmentTest {

	@Autowired
	private LocationService service;
	
	@Test
	public void create(){
		Location loc = new Location();
		loc.setAbbreviation("PEK");
		loc.setAddress("chang an street");
		loc.setCity("Beijing");
		Integer id = service.createLocation(loc);
		Location locationFromDB = service.getLocation(id);
		Assert.assertEquals(loc.getAbbreviation(), locationFromDB.getAbbreviation());
	}
	
	@Test
	public void update(){
		
		
	}
	
}
