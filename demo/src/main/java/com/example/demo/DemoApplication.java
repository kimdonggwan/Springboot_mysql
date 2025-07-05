package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.example.demo.mapper")  // 👈 여기에 추가!
public class DemoApplication {
	
	public static void main(String[] args) {
		System.out.println("demo server start....");
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("demo server end....");
	}

}

