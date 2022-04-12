package com.zenbaei.drones.domain.drone;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/drones")
public class DroneRestController {
	
    private final DroneService service;
	
	public DroneRestController(DroneService service) {
		this.service = service;
	}

    @GetMapping
    public List<Drone> findAll() {
        return service.findAll();
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
