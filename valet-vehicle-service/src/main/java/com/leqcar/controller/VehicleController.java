package com.leqcar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leqcar.domain.model.Ticket;
import com.leqcar.domain.model.Vehicle;
import com.leqcar.services.VehicleService;

@RestController
public class VehicleController {
	 
	@Autowired
	VehicleService vehicleService;
	
    @RequestMapping(method=RequestMethod.POST, value="/park")
    public Ticket park(@RequestBody Vehicle vehicle) {
    	System.out.println("Inside Park Vehicle");
    	return (vehicleService.parkVehicle(vehicle));
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/unPark")
    public Vehicle park(@RequestBody Ticket ticket) {
    	System.out.println("Inside unPark Vehicle");
    	return (vehicleService.unParkVehicle(ticket));
    }
}
