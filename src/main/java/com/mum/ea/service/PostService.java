package com.mum.ea.service;

import java.util.List;

import com.mum.ea.entities.Post;

public interface PostService {

	Post findPost(long id);

	void addPost(Post post);

	void addPost(String userName, String postText);

	void deletePost(Post post);

	void updatePost(Post post);

	void addComment(long postId, String commentText);

	/**
	 * Find user posts
	 * 
	 * @param userName
	 * @return
	 */
	List<Post> findUserPosts(String userName);

}
