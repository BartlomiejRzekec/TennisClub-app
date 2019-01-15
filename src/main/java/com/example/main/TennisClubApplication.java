package com.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.configuration.WebConfig;

@SpringBootApplication(scanBasePackageClasses = WebConfig.class)
public class TennisClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(TennisClubApplication.class, args);
	}

}

