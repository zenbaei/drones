package com.zenbaei.drones.domain.drone.service;

import java.util.List;


import javax.validation.Validator;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zenbaei.drones.common.service.AbstractService;
import com.zenbaei.drones.common.utils.ValidationUtils;
import com.zenbaei.drones.domain.drone.entity.Drone;
import com.zenbaei.drones.domain.drone.entity.Drone.Status;
import com.zenbaei.drones.domain.drone.repository.DroneRepository;
import com.zenbaei.drones.domain.medication.entity.Medication;

@Service
@Transactional
public class DroneServiceImpl extends AbstractService<Drone> implements DroneService {

	private final DroneRepository respository;
	private final Validator validator;

	public DroneServiceImpl(DroneRepository repository, Validator validator) {
		super(repository);
		this.respository = repository;
		this.validator = validator;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Drone getByIdEagerly(long id) {
		Drone drone = this.respository.getById(id);
		drone.getMedications().size();
		return drone;
	}

	@Override
	public void update(long id, Drone drone) {
		Drone drn = respository.getById(id);
		drn.setMedications(drone.getMedications());
		drn.setWeight(sumWeight(drone.getMedications()));
		drn.setStatus(Status.LOADED);
		
		ValidationUtils.check(this.validator.validate(drn));
		
		this.respository.save(drn);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Drone> findByStatus(Status status) {
		return this.respository.findByStatus(status);
	}

	
	protected static double sumWeight(List<Medication> medications) {
		if (medications == null || medications.isEmpty()) {
			return 0;
		}
		return medications.stream().map((m) -> m.getWeight()).reduce(0d, Double::sum);
	}
}
