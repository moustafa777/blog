package com.mum.ea.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mum.ea.entities.Role;

public interface RoleDAO extends JpaRepository<Role, Integer> {
	@Query("select distinct r from Role r join r.users u where u.id =:id")
	public List<Role> findRolesName(@Param("id") Long id);
	
	
}
