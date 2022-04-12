package com.zenbaei.drones.domain.drone;

import java.util.List;

import javax.transaction.Transactional;

import javax.validation.Validator;

import org.springframework.stereotype.Service;

import com.zenbaei.drones.common.service.AbstractService;
import com.zenbaei.drones.common.utils.ValidationUtils;
import com.zenbaei.drones.domain.drone.Drone.Status;
import com.zenbaei.drones.domain.medication.Medication;

@Service
public class DroneService extends AbstractService<Drone> {

	private final DroneRepository respository;
	private final Validator validator;

	public DroneService(DroneRepository repository, Validator validator) {
		super(repository);
		this.respository = repository;
		this.validator = validator;
	}

	@Transactional
	public void update(long id, Drone drone) {
		Drone drn = respository.getById(id);
		drn.setMedications(drone.getMedications());
		drn.setWeight(sumWeight(drone.getMedications()));
		drn.setStatus(Status.LOADED);
		
		ValidationUtils.check(this.validator.validate(drone));
		this.respository.save(drn);
	}

	private double sumWeight(List<Medication> medications) {
		if (medications == null || medications.isEmpty()) {
			return 0;
		}
		return medications.stream().map((m) -> m.getWeight()).reduce(0d, Double::sum);
	}


}
