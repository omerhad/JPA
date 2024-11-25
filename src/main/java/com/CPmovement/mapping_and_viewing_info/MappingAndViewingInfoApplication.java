package com.CPmovement.mapping_and_viewing_info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MappingAndViewingInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingAndViewingInfoApplication.class, args);
	}

}
