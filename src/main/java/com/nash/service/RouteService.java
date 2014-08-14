package com.nash.service;

import com.nash.model.Route;

public interface RouteService {
	public Integer save(Route route);
	public void removeById(Integer id);
}
