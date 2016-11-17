package com.leqcar.controller;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import com.leqcar.model.Ticket;
import com.leqcar.model.Vehicle;

public class ValetApiGatewayControllerTest {
	
	RestTemplate restTemplate = new RestTemplate();

	
	@Test
	public void park() {
		ResponseEntity<Ticket> exchange = null;
    	HttpHeaders headers = new HttpHeaders();
		Vehicle vehicle = new Vehicle();
		vehicle.setPlateNo("TWJ143");
        HttpEntity<Vehicle> request = new HttpEntity<Vehicle>(vehicle,headers);
        
    	try {
        exchange =
                this.restTemplate.exchange(
                		"http://localhost:9000/park/valet-vehicle-service",
                        HttpMethod.POST,
                        request,
                        Ticket.class);
        System.out.println(exchange.getBody());
        assertThat(exchange.getBody().getVehicleNo(), equalTo("TWJ143"));
        
    	} catch (Exception ex) {
    		ex.printStackTrace();
    		System.out.println(ex.getMessage());
    	}   
	}
	
	//@Test
	public void unPark() {
		ResponseEntity<Vehicle> exchange = null;
    	HttpHeaders headers = new HttpHeaders();
		Ticket ticket = new Ticket();
		ticket.setTicketId("102");
        HttpEntity<Ticket> request = new HttpEntity<Ticket>(ticket,headers);
        
    	try {
        exchange =
                this.restTemplate.exchange(
                		"http://localhost:9000/unpark/valet-vehicle-service",
                        HttpMethod.POST,
                        request,
                        Vehicle.class);
        System.out.println(exchange.getBody());
        assertThat(exchange.getBody().getPlateNo(), equalTo("TWJ142"));
        
    	} catch (Exception ex) {
    		ex.printStackTrace();
    		System.out.println(ex.getMessage());
    	}   
	}
	
}
