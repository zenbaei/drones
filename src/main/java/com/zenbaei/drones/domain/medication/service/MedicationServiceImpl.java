package com.zenbaei.drones.domain.medication.service;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.zenbaei.drones.common.service.AbstractService;
import com.zenbaei.drones.domain.medication.entity.Medication;
import com.zenbaei.drones.domain.medication.repository.MedicationRepository;

@Service
@Transactional
public class MedicationServiceImpl extends AbstractService<Medication> implements MedicationService {

	public MedicationServiceImpl(MedicationRepository repository) {
		super(repository);
	}
	
	

}
