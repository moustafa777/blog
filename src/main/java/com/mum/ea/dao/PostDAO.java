package com.mum.ea.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mum.ea.entities.Post;

@Repository
public interface PostDAO extends JpaRepository<Post, Long> {

	/**
	 * Find
	 * 
	 * @param userName
	 * @return
	 */
	List<Post> findByPostOwnerUserName(String userName);
}
