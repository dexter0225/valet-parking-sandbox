package com.leqcar.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
class RestTemplateClient implements CommandLineRunner {

	@Autowired
    private DiscoveryClient discoveryClient;
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public void run(String... strings) throws Exception {

//    	ResponseEntity<String> exchange = null;
//    	
//    	try {
//        exchange =
//                this.restTemplate.exchange(
//                        getUrl("valet-vehicle-service", "/vehicle"),
//                        HttpMethod.GET,
//                        null,
//                        String.class);
//        System.out.println(exchange.getBody());
//        
//    	} catch (Exception ex) {
//    		
//    		System.out.println(ex.getMessage());
//    	}   
    }
    
    public String getUrl(String serviceId, String path) {
    	return String.format("%s%s", discoveryClient.getInstances(serviceId).get(0).getUri(), path);
    }

}
