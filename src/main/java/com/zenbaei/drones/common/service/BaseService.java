package com.zenbaei.drones.common.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
	
	List<T> findAll();
	
	T save(T entity);
	
	Optional<T> findById(Long id);

}
