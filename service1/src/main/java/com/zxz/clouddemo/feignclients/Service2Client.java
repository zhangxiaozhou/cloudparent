package com.zxz.clouddemo.feignclients;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Component
public class Service2Client {


    @Resource
    public OAuth2RestTemplate oAuth2RestTemplate;

    public String getHost(){

        ResponseEntity<String> entity = oAuth2RestTemplate.getForEntity("http://service2/consul/getHost", String.class);

        return entity.getBody();
    }
}