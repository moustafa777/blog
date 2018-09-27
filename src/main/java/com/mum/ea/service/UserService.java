package com.mum.ea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mum.ea.entities.User;
import com.mum.ea.dao.UserDAO;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDAO userDAO;
	public void saveUser(User user) {
		userDAO.save(user);
		
	}
}
