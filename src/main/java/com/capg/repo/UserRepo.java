package com.capg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.User;

public interface UserRepo  extends JpaRepository<User, Long>{
	
	User findByUserId(int id);
	User findByEmail(String s);
	User findByPassword(String s);

}