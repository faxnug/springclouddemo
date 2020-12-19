package com.why.microserviceconsumer.feign;

import com.why.config.FeignConfiguration;
import com.why.microserviceconsumer.entity.User;
import feign.Param;
import feign.RequestLine;
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
@FeignClient(name = "microservice-provider", configuration = FeignConfiguration.class)
public interface UserFeignClient {
    @RequestLine("GET /simple/{id}")
    public User findById(@Param("id") Long id);
}
