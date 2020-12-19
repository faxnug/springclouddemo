package com.why.microserviceconsumer.feign;

import com.why.microserviceconsumer.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author WHY
 * @Date 2020-12-19
 * @Version 1.0
 */
@FeignClient("microservice-provider")
public interface UserFeignClient {
    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id);

    @PostMapping(value = "/user")
    public User postUser(@RequestBody User user);
}
