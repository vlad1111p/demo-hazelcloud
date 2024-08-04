package com.demoHazelcast.demoHazelcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages =  "com.demoHazelcast.demoHazelcast")
@EnableAutoConfiguration
public class DemoHazelcastApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoHazelcastApplication.class, args);
	}

}
