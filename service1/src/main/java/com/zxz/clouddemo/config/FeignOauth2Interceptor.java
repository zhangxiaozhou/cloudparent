package com.zxz.clouddemo.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import javax.annotation.Resource;

@Slf4j
@Configuration
public class FeignOauth2Interceptor  implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";

    private static final String BEARER_TOKEN_TYPE = "Bearer";

    @Resource
    private OAuth2RestTemplate oAuth2RestTemplate;

    @Override
    public void apply(RequestTemplate requestTemplate) {

        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if(authentication instanceof OAuth2Authentication){
                OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) (authentication.getDetails());
                requestTemplate.header(AUTHORIZATION_HEADER, BEARER_TOKEN_TYPE + " " + details.getTokenValue());
            }
        } catch (Exception e) {
            log.error("feign传递token异常", e);
        }

    }
}
