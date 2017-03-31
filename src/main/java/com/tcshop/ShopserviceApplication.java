package com.tcshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.tcshop.dao")
public class ShopserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopserviceApplication.class, args);
	}
}
