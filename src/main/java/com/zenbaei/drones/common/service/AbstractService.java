package com.zenbaei.drones.common.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<T> implements BaseService<T> {
	
	private JpaRepository<T, Long> repository;
	
	public AbstractService(JpaRepository<T, Long> repository) {
		this.repository = repository;
	}
	
	@Override
	public List<T> findAll() {
		return this.repository.findAll();
	}
	
	@Override
	public T save(T entity) {
		return this.repository.save(entity);
	}
	
	@Override
	public Optional<T> findById(Long id) {
		return this.repository.findById(id);
	}

}
