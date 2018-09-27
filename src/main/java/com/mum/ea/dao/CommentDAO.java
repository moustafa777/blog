package com.mum.ea.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mum.ea.entities.Comment;

public interface CommentDAO extends JpaRepository<Comment, Long> {

}
