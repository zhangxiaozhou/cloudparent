package com.zxz.clouddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Service4
{
    public static void main( String[] args )
    {
        SpringApplication.run(Service4.class);
    }
}
