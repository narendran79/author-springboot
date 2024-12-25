package com.example.Author.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "author_test")
public class Author {
 
	@Id
	private Integer authorId;
	private String userName;
	private String profilePic;
	private String bio;
	
	public Author() {
		
	}

	public Author(Integer authorId, String userName, String profilePic, String bio) {
		super();
		this.authorId = authorId;
		this.userName = userName;
		this.profilePic = profilePic;
		this.bio = bio;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
	
}
