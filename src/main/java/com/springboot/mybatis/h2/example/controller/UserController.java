package com.springboot.mybatis.h2.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import com.springboot.mybatis.h2.example.service.UserService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/transferPoints")
	public ResponseEntity<String> transferPoints(@RequestParam Long fromId, @RequestParam Long toId, @RequestParam Long points) {

		if (!userService.transferPoints(fromId, toId, points)) {
			return new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

}
