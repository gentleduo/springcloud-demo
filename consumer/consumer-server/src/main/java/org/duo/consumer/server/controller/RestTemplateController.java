package org.duo.consumer.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 利用@LoadBalanced注解：
 * 使用RestTemplate进行rest操作的时候，会自动使用负载均衡策略，它内部会在RestTemplate中加入LoadBalancerInterceptor这个拦截器，
 * 这个拦截器的作用就是使用负载均衡。
 */
@RestController
@RequestMapping("/resttemplate")
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/msg")
    public String getMsg() {

        String response = restTemplate.getForObject("http://producer-service/producer-service/msg", String.class);
        return response;
    }
}
