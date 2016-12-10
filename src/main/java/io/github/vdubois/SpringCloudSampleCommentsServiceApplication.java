package io.github.vdubois;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableCaching
public class SpringCloudSampleCommentsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSampleCommentsServiceApplication.class, args);
	}
}
