package com.why.microserviceconsumer.controller;

import com.why.microserviceconsumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/movie/{id}", produces = "application/json")
    public User findById(@PathVariable Long id){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider");
        System.out.println(serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());

        //VIP virtual IP
        //HAProxy Heartbeat
        return restTemplate.getForObject("http://microservice-provider/simple/" + id, User.class);
    }

}
