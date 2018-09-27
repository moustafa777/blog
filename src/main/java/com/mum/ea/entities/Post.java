package com.mum.ea.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 
 * @author Yahia
 *
 */
@Entity
public class Post implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Lob
	private String text;

	private int votesNumber;

	@Embedded
	private CreationInfo creationInfo;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private User postOwner;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comments = new ArrayList<>();

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

	public int getVotesNumber() {
		return votesNumber;
	}

	public void setVotesNumber(int votesNumber) {
		this.votesNumber = votesNumber;
	}

	public CreationInfo getCreationInfo() {
		return creationInfo;
	}

	public void setCreationInfo(CreationInfo creationInfo) {
		this.creationInfo = creationInfo;
	}

	public User getPostOwner() {
		return postOwner;
	}

	public void setPostOwner(User postOwner) {
		this.postOwner = postOwner;
	}

	public List<Comment> getComments() {
		return Collections.unmodifiableList(comments);
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void addComment(Comment comment) {

		comment.setPost(this);
		comments.add(comment);
	}

	public boolean removeComment(Comment comment) {

		comment.setPost(null);
		return comments.remove(comment);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(creationInfo).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Post) {
			final Post other = (Post) obj;
			return new EqualsBuilder().append(id, other.id).append(creationInfo, other.creationInfo).isEquals();
		} else {
			return false;
		}
	}

}
