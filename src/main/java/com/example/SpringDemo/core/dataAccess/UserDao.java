package com.example.SpringDemo.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringDemo.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	User findByEmail(String email);
	
	

}
