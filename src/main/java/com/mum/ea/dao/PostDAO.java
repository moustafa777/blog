package com.mum.ea.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mum.ea.entities.Post;

public interface PostDAO extends JpaRepository<Post, Integer> {

}
