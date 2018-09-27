package com.mum.ea.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.ea.dao.PostDAO;
import com.mum.ea.dao.UserDAO;
import com.mum.ea.entities.Comment;
import com.mum.ea.entities.CreationInfo;
import com.mum.ea.entities.Post;
import com.mum.ea.entities.User;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PostServiceImpl implements PostService {

	@Resource
	private PostDAO postDao;

	@Resource
	private UserDAO userDAO;

	@Override
	public void addPost(Post post) {
		postDao.save(post);
	}

	@Override
	public void addPost(String userName, String postText) {

		// Find user
		User user = userDAO.findByUserName(userName);

		// Create new post
		Post post = new Post();
		post.setText(postText);
		post.setCreationInfo(new CreationInfo(LocalDate.now(), LocalTime.now()));
		post.setPostOwner(user);

		// Save post
		addPost(post);

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
		return postDao.findById(id).orElse(null);
	}

	@Override
	public void addComment(long postId, String commentText) {

		Comment comment = new Comment(commentText);
		comment.setCreationInfo(new CreationInfo(LocalDate.now(), LocalTime.now()));

		Post post = findPost(postId);

		post.addComment(comment);
	}

	@Override
	public List<Post> findUserPosts(String userName) {
		return postDao.findByPostOwnerUserName(userName);
	}

}
