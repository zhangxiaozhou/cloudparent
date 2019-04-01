package com.zxz.clouddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@EnableOAuth2Sso
@EnableDiscoveryClient
@SpringBootApplication
public class SsoClient2
{
    public static void main( String[] args )
    {
        SpringApplication.run(SsoClient2.class);
    }
}
