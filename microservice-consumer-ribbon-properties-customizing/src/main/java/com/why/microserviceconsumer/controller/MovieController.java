package com.why.microserviceconsumer.controller;

import com.why.microserviceconsumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author WHY
 * @Date 2020-12-17
 * @Version 1.0
 */
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/movie/{id}", produces = "application/json")
    public User findById(@PathVariable Long id){
        //VIP virtual IP
        //HAProxy Heartbeat
        return this.restTemplate.getForObject("http://microservice-provider/simple/" + id, User.class);
    }
}
