package com.loginportal.forgotpassword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
@SpringBootApplication

//@EnableEurekaClient
public class ForgotpasswordApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForgotpasswordApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
