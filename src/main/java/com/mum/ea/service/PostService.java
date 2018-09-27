package com.mum.ea.service;

import com.mum.ea.entities.Post;

public interface PostService {

	Post findPost(long id);

	void addPost(Post post);

	void deletePost(Post post);

	void updatePost(Post post);

}
