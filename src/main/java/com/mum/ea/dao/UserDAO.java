package com.mum.ea.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mum.ea.entities.User;

public interface UserDAO extends JpaRepository<User, Integer> {

}
