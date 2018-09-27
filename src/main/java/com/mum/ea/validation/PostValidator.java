package com.mum.ea.validation;

import org.springframework.validation.Errors;

import com.mum.ea.entities.Post;

/**
 * 
 * @author Yahia
 *
 */
public class PostValidator extends AbstractValidation {

	@Override
	public boolean supports(Class<?> clazz) {
		return Post.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Post post = (Post) target;

		// Validate post text
		if (post.getText() == null || post.getText().trim().isEmpty()) {
			errors.rejectValue("text", ErrorCodes.POST_TEXT_CAN_NOT_EMPTY);
		}

	}

}
