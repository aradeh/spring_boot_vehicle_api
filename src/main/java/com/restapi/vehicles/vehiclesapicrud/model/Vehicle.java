package com.restapi.vehicles.vehiclesapicrud.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

/**
 * The type Vehicle.
 *
 * @author Harshad
 */

@Entity
@Table( name = "vehicles" )
public class Vehicle {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	@Column(name = "year")
	private int year;
	
	@Column(name = "make")
	private String Make;
	
	@Column(name = "model")
	private String Model;

	//Default Constructor
	public Vehicle() {
		super();
	}

	public Vehicle(int year, String make, String model) {
		super();
		this.year = year;
		Make = make;
		Model = model;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getMake() {
		return Make;
	}
	
	public void setMake(String make) {
		Make = make;
	}
	
	public String getModel() {
		return Model;
	}
	
	public void setModel(String model) {
		Model = model;
	}

}
