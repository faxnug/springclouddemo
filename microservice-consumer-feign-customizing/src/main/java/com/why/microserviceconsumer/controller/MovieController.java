package com.why.microserviceconsumer.controller;

import com.why.microserviceconsumer.entity.User;
import com.why.microserviceconsumer.feign.UserFeignClient;
import feign.Param;
import feign.RequestLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author WHY
 * @Date 2020-12-17
 * @Version 1.0
 */
@RestController
public class MovieController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping(value = "/movie/{id}", produces = "application/json")
    public User findById(@PathVariable Long id){
        return this.userFeignClient.findById(id);
    }

}
