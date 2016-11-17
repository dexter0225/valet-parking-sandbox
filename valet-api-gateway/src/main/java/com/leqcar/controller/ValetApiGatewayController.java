package com.leqcar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.leqcar.model.Ticket;
import com.leqcar.model.Vehicle;

@RestController
public class ValetApiGatewayController {
	private static final String SERVICE_A = "valet-vehicle-service";
 
	@Autowired
    private DiscoveryClient discoveryClient;
	
	@Autowired
    private RestTemplate restTemplate;
    
		@RequestMapping(method=RequestMethod.POST, value="/park/{service}")
	    public String parkVehicle(@PathVariable("service") String service, @RequestBody Vehicle vehicle) {
	        ResponseEntity<String> exchange = null;
	        HttpEntity<Vehicle> request = new HttpEntity<Vehicle>(vehicle);
	        
	    	try {
	        exchange =
	                this.restTemplate.exchange(
	                		getUrl(service, "/park"),
	                        HttpMethod.POST,
	                        request,
	                        String.class);
	        System.out.println(exchange.getBody());
	        
	    	} catch (Exception ex) {
	    		ex.printStackTrace();
	    		System.out.println(ex.getMessage());
	    	}   
	        
	    	return exchange.getBody();
	    }
		
		@RequestMapping(method=RequestMethod.POST, value="/unpark/{service}")
	    public String unParkVehicle(@PathVariable("service") String service, @RequestBody Ticket ticket) {
	        ResponseEntity<String> exchange = null;
	        HttpEntity<Ticket> request = new HttpEntity<Ticket>(ticket);
	        
	    	try {
	        exchange =
	                this.restTemplate.exchange(
	                		getUrl(service, "/unPark"),
	                        HttpMethod.POST,
	                        request,
	                        String.class);
	        System.out.println(exchange.getBody());
	        
	    	} catch (Exception ex) {
	    		ex.printStackTrace();
	    		System.out.println(ex.getMessage());
	    	}   
	        
	    	return exchange.getBody();
	    }
	
    @RequestMapping(method=RequestMethod.GET, value="/valet/{service}")
    public String parkVehicle(@PathVariable("service") String service) {
        ResponseEntity<String> exchange = null;
    	
    	try {
        exchange =
                this.restTemplate.exchange(
                		getUrl(service, "/park"),
                        HttpMethod.GET,
                        null,
                        String.class);
        System.out.println(exchange.getBody());
        
    	} catch (Exception ex) {
    		ex.printStackTrace();
    		System.out.println(ex.getMessage());
    	}   
        
    	return exchange.getBody();
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/valet")
    public String getProfileNamesForService() {
        String result = parkVehicle(SERVICE_A, new Vehicle());
        return result;
    }

    public String getUrl(String serviceId, String path) {
    	return String.format("%s%s", discoveryClient.getInstances(serviceId).get(0).getUri(), path);
    }
}
