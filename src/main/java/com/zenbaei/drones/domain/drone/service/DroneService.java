package com.zenbaei.drones.domain.drone.service;

import java.util.List;

import com.zenbaei.drones.common.service.BaseService;
import com.zenbaei.drones.domain.drone.entity.Drone;
import com.zenbaei.drones.domain.drone.entity.Drone.Status;

public interface DroneService extends BaseService<Drone> {

	List<Drone> findByStatus(Status status);
	
	Drone getByIdEagerly(long id);
	
	void update(long id, Drone drone);
}
