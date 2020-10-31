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


/**
 * The type Vehicle controller.
 *
 * @author Harshad
 */


@RestController
@RequestMapping("/api/v1/")
public class VehicleController {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	//get vehicles //GET
	/**
	   * Get all vehicles list.
	   *
	   * @return the list
	   */
	
	
	@GetMapping("vehicles")
	public List<Vehicle> getAllVehicle(){
		return this.vehicleRepository.findAll();
	}
	
	
	//get vehicles by id //GET
	/**
	   * Gets vehicles by id.
	   *
	   * @param vehicleId the vehicle id
	   * @return the vehicles by id
	   * @throws ResourceNotFoundException the resource not found exception
	   */
	
	@GetMapping("vehicles/{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable(value = "id") Long vehicleId) throws ResourceNotFoundException {
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id ::" + vehicleId));
		return ResponseEntity.ok().body(vehicle);
	}
	
	//save vehicle //POST
	/**
	   * Create Vehicle vehicle.
	   *
	   * @param vehicle the Vehicle
	   * @return the vehicle object
	   */
	@PostMapping("vehicles")
	public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
		return this.vehicleRepository.save(vehicle);
	}
	
	//update vehicle //PUT
	/**
	   * Update vehicle response entity.
	   *
	   * @param vehicleId the vehicle id
	   * @param vehicleDetails the vehicle details
	   * @return the response entity
	   * @throws ResourceNotFoundException the resource not found exception
	   */
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
	/**
	   * Delete vehicle map.
	   *
	   * @param vehicleId the vehicle id
	   * @return the map
	   * @throws Exception the exception
	   */
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
