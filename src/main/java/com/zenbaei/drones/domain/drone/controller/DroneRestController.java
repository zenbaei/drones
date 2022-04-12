package com.zenbaei.drones.domain.drone.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zenbaei.drones.domain.drone.entity.Drone;
import com.zenbaei.drones.domain.drone.entity.Drone.Status;
import com.zenbaei.drones.domain.drone.service.DroneService;


@RestController
@RequestMapping("/api/drones")
public class DroneRestController {
	
    private final DroneService service;
	
	public DroneRestController(DroneService service) {
		this.service = service;
	}

    @GetMapping
    public List<Drone> findAll(@RequestParam(required = false) Status status) {
    	if (status != null) {
    		return service.findByStatus(status);
    	}
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public Drone findById(@PathVariable Long id) {
        return service.getByIdEagerly(id);
    }
    
    
    @PostMapping
    public Drone save(@Valid @RequestBody Drone drone) {
    	return service.save(drone);
    }
    
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody Drone drone) {
    	service.update(id, drone);
    }
    
}
