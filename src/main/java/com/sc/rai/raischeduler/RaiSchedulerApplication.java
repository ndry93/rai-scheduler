package com.sc.rai.raischeduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RaiSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaiSchedulerApplication.class, args);
	}

}
