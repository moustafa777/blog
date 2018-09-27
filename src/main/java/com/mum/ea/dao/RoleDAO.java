package com.mum.ea.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mum.ea.entities.Role;

public interface RoleDAO extends JpaRepository<Role, Integer> {
//	@Query("select r.roleName from Role r, User_Role ur where ur.role_id = r.id and ur.id = :id")
	@Query("select r.roleName from Role r")
	public List<String> findRolesName(@Param("id") Long id);
}
