package com.brv;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brv.models.Rating;
import com.brv.models.UserRating;


@RestController
@RequestMapping("/ratingsdata") 
public class RatingResource {

	public RatingResource() {
		// TODO Auto-generated constructor stub
	}

	
	@RequestMapping("/movies/{movieId}")
	public Rating getMovieRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 5);
	}
	
	@RequestMapping("/user/{userId}")
	public UserRating getUserRatings(@PathVariable("userId") String userId) {
		UserRating userRating = new UserRating();
		userRating.initData(userId);
		return userRating;
	}
	
}
