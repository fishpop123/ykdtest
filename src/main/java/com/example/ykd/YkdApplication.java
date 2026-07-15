package com.example.ykd;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class YkdApplication {
	public static void main(String[] args) {
		SpringApplication.run(YkdApplication.class, args);
		log.info("Spring boot启动成功");
	}
}
