package com.nash.dao;

import java.util.List;

import com.nash.model.Route;

public interface RouteDao {
	List<Route> findByPickUpLocation();
}
