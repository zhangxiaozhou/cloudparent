package com.zxz.clouddemo.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Base64;

@RestController
public class LoginController {

    private static final String GRANT_TYPE = "password";

    @Value("${security.oauth2.client.clientId}")
    private String clientId;

    @Value("${security.oauth2.client.clientSecret}")
    private String clientSecret;

    private static final String authServerUri = "authserver/auth";

    private static final String accessTokenUri = "/oauth/token";

    private static final String protocol = "http://";

    private static final String accessTokenUrl = protocol + authServerUri + accessTokenUri;

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/login")
    public Object login(String username, String password){

        HttpHeaders headers = new HttpHeaders();

        String userMsg = clientId + ":" + clientSecret;
        String base64UserMsg = Base64.getEncoder().encodeToString(userMsg.getBytes());

        String authHeader = "Basic " + base64UserMsg;
        headers.set("Authorization", authHeader );

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);


        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("grant_type", GRANT_TYPE);
        map.add("username", username);
        map.add("password", password);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<Object> objectResponseEntity = restTemplate.postForEntity(accessTokenUrl, request, Object.class);

        return objectResponseEntity;
    }
}
