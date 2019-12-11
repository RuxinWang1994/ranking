package com.example.ranking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class RankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RankingApplication.class, args);
		System.out.println("程序在运行");
	}

}
