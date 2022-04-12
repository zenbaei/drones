package com.zenbaei.drones.domain.medication;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.zenbaei.drones.common.service.AbstractService;

@Service
@Transactional
public class MedicationService extends AbstractService<Medication>{

	public MedicationService(MedicationRepository repository) {
		super(repository);
	}
	
	

}
