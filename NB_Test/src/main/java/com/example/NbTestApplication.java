package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@SpringBootApplication
public class NbTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(NbTestApplication.class, args);
	}
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}
	@Bean(name="jsonView")
	MappingJackson2JsonView jsonView() {
		return new MappingJackson2JsonView(); 
	}
}
