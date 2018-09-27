package com.mum.ea.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.ea.dao.PostDAO;
import com.mum.ea.entities.Post;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PostServiceImpl implements PostService {

	@Resource
	private PostDAO postDao;

	@Override
	public void addPost(Post post) {
		postDao.save(post);
	}

	@Override
	public void deletePost(Post post) {
		postDao.delete(post);

	}

	@Override
	public void updatePost(Post post) {
		post.setText(post.getText());
	}

	@Override
	public Post findPost(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
