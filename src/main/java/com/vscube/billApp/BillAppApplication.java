package com.vscube.billApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication

@EntityScan(basePackages = {"com.vscube.billApp"} )
public class BillAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillAppApplication.class, args);
	}

}
