package com.example.discover;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RequestMapping("")
public class DiscoverApplication {
	@Autowired
	DiscoveryClient discoveryClient;
	@GetMapping("")
	public String try_disc(){
		Map<String, Object> a=new HashMap<>();
		a.put("hi","hi");
		List<ServiceInstance> list = discoveryClient.getInstances("home-service");
        if (list != null && list.size() > 0 ) {
            URI uri =  list.get(0).getUri();
            return uri.toString();
        }
		return "hi";
	}
	public static void main(String[] args) {
		SpringApplication.run(DiscoverApplication.class, args);
	}

}
