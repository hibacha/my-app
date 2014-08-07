package com.nash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nash.dao.LocationDao;
import com.nash.model.Location;

@Service("locationService")
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationDao locationDao;

	@Override
	@Transactional
	public void createLocation(Location location) {
		locationDao.create(location);
		throw new RuntimeException("ddd");
	}

}
