package com.mum.ea.entities;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 
 * @author Yahia
 *
 */
@Entity
public class Comment implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Lob
	private String text;

	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;

	@Embedded
	private CreationInfo creationInfo;

	public Comment() {
	}

	public Comment(String text) {
		this.text = text;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public CreationInfo getCreationInfo() {
		return creationInfo;
	}

	public void setCreationInfo(CreationInfo creationInfo) {
		this.creationInfo = creationInfo;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(creationInfo).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Post) {
			final Comment other = (Comment) obj;
			return new EqualsBuilder().append(id, other.id).append(creationInfo, other.creationInfo).isEquals();
		} else {
			return false;
		}
	}

}
