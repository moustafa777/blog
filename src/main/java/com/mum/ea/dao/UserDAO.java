package com.mum.ea.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mum.ea.entities.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

	
		
}
