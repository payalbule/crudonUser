package com.bank.example.Banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestBankingApplication {

	public static void main(String[] args) {
		SpringApplication.from(BankingApplication::main).with(TestBankingApplication.class).run(args);
	}

}
