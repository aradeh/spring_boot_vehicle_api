package com.restapi.vehicles.vehiclesapicrud;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import com.restapi.vehicles.vehiclesapicrud.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VehiclesApiCrudApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
class VehiclesApiCrudApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	
	private String getRootUrl() {
		return "http://localhost:" + port;
	}
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testGetAllVehicles() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null,headers);
		
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl()+"/api/v1/vehicles",HttpMethod.GET, entity,String.class);
		
		Assert.assertNotNull(response.getBody());
	}
	
	@Test
	public void testCreateVehicle() {
		Vehicle vehicle = new Vehicle();
		vehicle.setYear(2020);
		vehicle.setMake("mercedes benz");
		vehicle.setModel("E350");
		
		ResponseEntity<Vehicle> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/v1/vehicles", vehicle, Vehicle.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());

	}
	
	@Test
	public void testUpdateVehicle() {
		int id = 1;
		Vehicle vehicle = restTemplate.getForObject(getRootUrl() + "/api/v1/vehicles/" + id, Vehicle.class);
		vehicle.setMake("Toyota");
		vehicle.setModel("Corolla");
		vehicle.setYear(2018);
		
		restTemplate.put(getRootUrl()+ "/api/v1/vehicle"+id, vehicle);
		
		Vehicle updatedVehicle = restTemplate.getForObject(getRootUrl()+"/api/v1/vehicles/" + id, Vehicle.class);
		Assert.assertNotNull(updatedVehicle);	
	}
	
	@Test
	public void testDeleteVehicle() {
		int id = 2;
		Vehicle vehicle = restTemplate.getForObject(getRootUrl() + "/api/v1/vehicles/" + id, Vehicle.class);
		Assert.assertNotNull(vehicle);

		restTemplate.delete(getRootUrl() + "/api/v1/vehicles/" + id);

		try {
			vehicle = restTemplate.getForObject(getRootUrl() + "/api/v1/vehicles" + id, Vehicle.class);
		} catch (final HttpClientErrorException e) {
			Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
