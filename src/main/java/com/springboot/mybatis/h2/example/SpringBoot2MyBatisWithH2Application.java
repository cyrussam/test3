package com.springboot.mybatis.h2.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;

import com.springboot.mybatis.h2.example.User.User;
import com.springboot.mybatis.h2.example.User.UserMyBatisRepository;

@SpringBootApplication
public class SpringBoot2MyBatisWithH2Application {

	@Autowired
	private UserMyBatisRepository userRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2MyBatisWithH2Application.class, args);
	}

	@PostConstruct
	private void initDB() {
		logger.info("Inserting -> {}", userRepository.insert(new User(10010L, "UserA", 5000L)));
		logger.info("Inserting -> {}", userRepository.insert(new User(10011L, "UserB", 5000L)));
		logger.info("Inserting -> {}", userRepository.insert(new User(10012L, "UserC", 5000L)));
		logger.info("All users -> {}", userRepository.findAll());
	}

}