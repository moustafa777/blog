package com.mum.ea.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mum.ea.entities.Role;


public interface RoleDAO extends JpaRepository<Role, Integer> {

}
