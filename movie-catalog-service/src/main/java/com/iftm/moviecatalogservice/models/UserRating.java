package com.iftm.moviecatalogservice.models;

import java.util.List;

public class UserRating {

	private List<Rating> userRating;

	public UserRating(List<Rating> userRating) {
		super();
		this.userRating = userRating;
	}
	
	public UserRating() {
		super();
	}

	List<Rating> getUserRating() {
		return userRating;
	}

	void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}
	
	
}
