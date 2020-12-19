package com.why.microserviceconsumer;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author WHY
 * @Date 2020-12-18
 * @Version 1.0
 */
@Configuration
@ExcludeFromComponentScan
public class TestConfiguration {
//    @Autowired
//    IClientConfig config;

    @Bean
    public IRule ribbonRule(){
        //负载均衡规则改为随机
        return new RandomRule();
    }
}
