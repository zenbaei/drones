package com.zenbaei.drones.domain.medication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenbaei.drones.domain.medication.entity.Medication;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

}
