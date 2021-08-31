package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserId(long userId);

	User findByUserName(String userName);
	
	User findByUserNameAndPassword(String userName, String password);

}
