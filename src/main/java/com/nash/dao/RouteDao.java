package com.nash.dao;

import java.util.List;

import com.nash.model.Route;

public interface RouteDao extends GenericDao<Route, Integer> {
	List<Route> findByPickUpLocation();
}
