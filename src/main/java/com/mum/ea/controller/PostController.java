package com.mum.ea.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mum.ea.entities.Post;
import com.mum.ea.exceptions.BussinessException;
import com.mum.ea.service.PostService;
import com.mum.ea.validation.PostValidator;

/**
 * 
 * @author Yahia
 *
 */
@RestController
@RequestMapping("/post")
public class PostController {

	@Resource
	private PostService postService;

	@RequestMapping(value = "/{userName}", method = RequestMethod.POST)
	public void addPost(@PathVariable String userName, @RequestBody Post post, final BindingResult bindingResult) {

		// Validate post
		PostValidator postValidator = new PostValidator();
		postValidator.validate(post, bindingResult);

		postService.addPost(userName, post);
	}

	@RequestMapping(value = "/{postId}", method = RequestMethod.POST)
	public void addComment(@PathVariable long postId, @RequestBody String commentText) {
		postService.addComment(postId, commentText);
	}

	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
	public @ResponseBody List<Post> getUserPosts(@PathVariable String userName) {
		return postService.findUserPosts(userName);
	}

	@ExceptionHandler(value = BussinessException.class)
	public ModelAndView handle(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("e", e);
		mav.setViewName("noSuchResource");
		return mav;
	}
}
