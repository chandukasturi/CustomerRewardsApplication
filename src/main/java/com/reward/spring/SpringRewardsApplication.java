package com.reward.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {"com.reward.*"}
)
public class SpringRewardsApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringRewardsApplication.class, args);
	}
}
