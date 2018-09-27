package com.mum.ea.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String firstName;
	private String lastName;

	private String email;

	private String userName;

	private String password;

	@OneToMany(mappedBy = "postOwner")
	private List<Post> posts;

	@ManyToMany
	@JoinTable
	List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Post> getPosts() {
		return Collections.unmodifiableList(posts);
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public void addPost(Post post) {

		post.setPostOwner(this);
		posts.add(post);
	}

	public boolean removePost(Post post) {

		post.setPostOwner(null);
		return posts.remove(post);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(email).append(userName).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			final User other = (User) obj;
			return new EqualsBuilder().append(id, other.id).append(firstName, other.firstName)
					.append(lastName, other.lastName).append(email, other.email).append(userName, other.userName)
					.isEquals();
		} else {
			return false;
		}
	}

}
