package com.yfain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
/*
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;*/
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.yfain.controller")
public class SpringBootRestProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestProductsApplication.class, args);
	}
}
