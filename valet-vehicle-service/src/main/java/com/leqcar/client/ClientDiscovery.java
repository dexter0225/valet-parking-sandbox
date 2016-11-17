package com.leqcar.client;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
class ClientDiscovery implements CommandLineRunner {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public void run(String... strings) throws Exception {
//        discoveryClient.getInstances("valet-vehicle-service").forEach((ServiceInstance s) -> {
//        	System.out.println("Service Id = " + discoveryClient.getInstances("valet-vehicle-service").get(0).getServiceId());
//        	System.out.println("Service URI = " + discoveryClient.getInstances("valet-vehicle-service").get(0).getUri());
//            System.out.println(ToStringBuilder.reflectionToString(s));
//        });
    }
}


