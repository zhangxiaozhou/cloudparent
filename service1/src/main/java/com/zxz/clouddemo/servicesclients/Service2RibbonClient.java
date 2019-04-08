package com.zxz.clouddemo.servicesclients;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * 演示ribbon调用下游服务时传递token，主要通过 oAuth2RestTemplate
 */
@Component
public class Service2RibbonClient {


    @Resource
    public OAuth2RestTemplate oAuth2RestTemplate;

    public String getHost(){

        ResponseEntity<String> entity = oAuth2RestTemplate.getForEntity("http://service2/consul/getHost", String.class);

        return entity.getBody();
    }
}