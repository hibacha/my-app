package com.nash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nash.dao.LocationDao;
import com.nash.model.Location;

@Service("locationService")
@Transactional
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationDao locationDao;

	@Override
	public Integer createLocation(Location location) {
		return locationDao.create(location);
		 
	}
	
	@Override
	public void deleteLocationById(Integer id){
		Location location = locationDao.read(id);
		locationDao.delete(location);
	}
}
