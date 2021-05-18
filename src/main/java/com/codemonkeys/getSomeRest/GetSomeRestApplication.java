package com.codemonkeys.getSomeRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GetSomeRestApplication {

	private static long systemInitTime = System.currentTimeMillis();

	public static void main(String[] args) {
		SpringApplication.run(GetSomeRestApplication.class, args);
	}

	public static long getSystemInitTime() {
		return systemInitTime;
	}

	public static void setSystemInitTime(long systemInitTime) {
		GetSomeRestApplication.systemInitTime = systemInitTime;
	}
}
