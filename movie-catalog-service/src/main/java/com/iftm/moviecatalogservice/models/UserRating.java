package com.iftm.moviecatalogservice.models;

import java.util.List;

public class UserRating {

	private String userId;
	private List<Rating> userRating;
	
	public UserRating(String userId, List<Rating> userRating) {
		super();
		this.userId = userId;
		this.userRating = userRating;
	}

	public UserRating() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Rating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}
}
