package com.restapi.vehicles.vehiclesapicrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restapi.vehicles.vehiclesapicrud.model.Vehicle;
import org.springframework.stereotype.*;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
