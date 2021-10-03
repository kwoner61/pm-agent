package com.junghokwon.pmagent;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication(scanBasePackages = "com.junghokwon.pmagent")
public class PerformanceMonitoringAgentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerformanceMonitoringAgentApplication.class, args);
	}

}
