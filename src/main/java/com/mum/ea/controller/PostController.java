package com.mum.ea.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mum.ea.entities.Post;
import com.mum.ea.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

	@Resource
	private PostService postService;

	@RequestMapping(value = "/{userName}", method = RequestMethod.POST)
	public void addPost(@PathVariable String userName, @RequestBody String postText) {
		postService.addPost(userName, postText);
	}

	@RequestMapping(value = "/{postId}", method = RequestMethod.POST)
	public void addComment(@PathVariable long postId, @RequestBody String commentText) {
		postService.addComment(postId, commentText);
	}

	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
	public @ResponseBody List<Post> getUserPosts(@PathVariable String userName) {
		return postService.findUserPosts(userName);
	}
}
