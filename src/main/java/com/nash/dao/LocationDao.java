package com.nash.dao;

import java.util.List;

import com.nash.model.Location;

public interface LocationDao extends GenericDao<Location, Integer>{
  List<Location> findByAbbreviation(String name);
}
