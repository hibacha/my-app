package com.nash.service;

import com.nash.model.Location;

public interface LocationService {
	public Integer createLocation(Location location);
	public void deleteLocationById(Integer id);
}
