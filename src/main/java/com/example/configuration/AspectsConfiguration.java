package com.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example.aspects.Transactions;

@Configuration
@EnableAspectJAutoProxy
public class AspectsConfiguration {

	

	@Bean
	public Transactions transactions() 
	{
		return new Transactions();
	}
}
