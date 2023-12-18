package com.capg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.User;

public interface UserRepo  extends JpaRepository<User, Long>{
	
	User findByUserId(int id);
	 // select * from users where email = s;
	User findByEmail(String s);
	// select * from users where password = s;
	User findByPassword(String s);

}