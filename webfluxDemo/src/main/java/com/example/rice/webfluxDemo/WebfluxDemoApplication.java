package com.example.rice.webfluxDemo;

import com.mongodb.MongoClientOptions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;

@SpringBootApplication
public class WebfluxDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxDemoApplication.class, args);
	}

	@Bean
	public MongoClientFactoryBean mongoClientFactoryBean() {
    	MongoClientFactoryBean factoryBean = new MongoClientFactoryBean();
		factoryBean.setHost("localhost");
		factoryBean.setPort(27017);
		factoryBean.setSingleton(true);		
		MongoClientOptions options = MongoClientOptions.builder()
			.connectionsPerHost(1000)												
			.minConnectionsPerHost(500)
			.threadsAllowedToBlockForConnectionMultiplier(10)
			.build();
		factoryBean.setMongoClientOptions(options);
    	return factoryBean;
	}
}
