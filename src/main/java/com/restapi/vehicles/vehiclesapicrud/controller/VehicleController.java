package com.restapi.vehicles.vehiclesapicrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.vehicles.vehiclesapicrud.repository.VehicleRepository;

import java.util.*;

import com.restapi.vehicles.vehiclesapicrud.model.Vehicle;
import org.springframework.http.ResponseEntity;
import com.restapi.vehicles.vehiclesapicrud.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v1/")
public class VehicleController {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	//get vehicles //GET
	@GetMapping("vehicles")
	public List<Vehicle> getAllVehicle(){
		return this.vehicleRepository.findAll();
	}
	
	//get vehicles by id //GET
	@GetMapping("vehicles/{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable(value = "id") Long vehicleId) throws ResourceNotFoundException {
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id ::" + vehicleId));
		return ResponseEntity.ok().body(vehicle);
	}
	
	//save vehicle //POST
	@PostMapping("vehicles")
	public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
		return this.vehicleRepository.save(vehicle);
	}
	
	//update vehicle //PUT
	@PutMapping("vehicles/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable(value = "id") Long vehicleId , @Validated @RequestBody Vehicle vehicleDetails)
				throws ResourceNotFoundException{
		
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id ::" + vehicleId));
		
		vehicle.setMake(vehicleDetails.getMake());
		vehicle.setModel(vehicleDetails.getModel());
		vehicle.setYear(vehicleDetails.getYear());
		
		return ResponseEntity.ok(this.vehicleRepository.save(vehicle));		
	}
	
	
	//delete vehicle
	@DeleteMapping("vehicles/{id}")
	public Map<String, Boolean> deleteVehicle(@PathVariable(value = "id") Long vehicleId) throws ResourceNotFoundException{
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id ::" + vehicleId));
		
		this.vehicleRepository.delete(vehicle);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Vehicle", Boolean.TRUE);
		
		return response;
	}
	

}
