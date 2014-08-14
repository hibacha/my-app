package com.nash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nash.dao.RouteDao;
import com.nash.model.Route;

@Service("routeService")
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteDao routeDao;
	
	@Transactional
	@Override
	public Integer save(Route route) {
		// TODO Auto-generated method stub
		return routeDao.create(route);
	}

	@Transactional
	@Override
	public void removeById(Integer id){
		Route bos2nyc = routeDao.read(id);
		routeDao.delete(bos2nyc);
	}
}
