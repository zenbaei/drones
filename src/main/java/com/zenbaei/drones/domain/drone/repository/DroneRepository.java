package com.zenbaei.drones.domain.drone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenbaei.drones.domain.drone.entity.Drone;
import com.zenbaei.drones.domain.drone.entity.Drone.Status;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {

	List<Drone> findByStatus(Status status);
}
