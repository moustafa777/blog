package com.mum.ea.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mum.ea.entities.User;

@Repository
@Transactional
public interface UserDAO extends JpaRepository<User, Integer> {

	public User findByUserName(String userName);
}
