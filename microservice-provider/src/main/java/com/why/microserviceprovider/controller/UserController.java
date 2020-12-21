package com.why.microserviceprovider.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.why.microserviceprovider.dao.UserRepository;
import com.why.microserviceprovider.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;

/**
 * @Author WHY
 * @Date 2020-12-17
 * @Version 1.0
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping(value = "/simple/{id}", produces = "application/json")
    public User findById(@PathVariable Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @PostMapping(value = "/user", consumes = "application/json", produces = "application/json")
    public User postUser(@RequestBody User user){
        return user;
    }

    @GetMapping(value = "/eureka-instance")
    public String serviceUrl() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER", false);
        return instance.getHomePageUrl();
    }
}
