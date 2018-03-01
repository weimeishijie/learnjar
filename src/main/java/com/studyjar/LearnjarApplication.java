package com.studyjar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class LearnjarApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnjarApplication.class, args);
	}
}
