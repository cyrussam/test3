package com.springboot.mybatis.h2.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.mybatis.h2.example.User.UserMyBatisRepository;
import org.springframework.stereotype.Component;
import com.springboot.mybatis.h2.example.User.User;

@Component
public class UserService {

  @Autowired
  private UserMyBatisRepository userRepository;


	private Logger logger = LoggerFactory.getLogger(this.getClass());

  public synchronized boolean transferPoints(Long fromId, Long toId, Long points) {

      User user1 = userRepository.findById(fromId.longValue());
      Long points1 = user1.getSore() - points;
      int n1 = userRepository.update(new User(fromId, user1.getName(), points1.longValue()));

      User user2 = userRepository.findById(toId.longValue());
      Long points2 = user2.getSore() + points;
      int n2 = userRepository.update(new User(toId, user2.getName(), points2.longValue()));

      logger.info("Ids -> " + n1 + "," + n2);

      logger.info("All users -> {}", userRepository.findAll());
      return true;    	
  }
}
