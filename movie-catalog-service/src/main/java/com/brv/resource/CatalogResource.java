package com.brv.resource;

import java.util.stream.Collectors;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brv.models.CatalogItem;
import com.brv.models.UserRating;
import com.brv.services.MovieInfo;
import com.brv.services.UserRatingInfo;


@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	public CatalogResource() {
		// TODO Auto-generated constructor stub
	}

	
	@Autowired
	MovieInfo movieInfo;
	
	@Autowired
	UserRatingInfo userRatingInfo;
	
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalogItem(@PathVariable("userId") String userId){
		UserRating userRating = userRatingInfo.getUserRating(userId);
		
		return userRating.getRatings().stream()
				.map(rating -> movieInfo.getCatalogItem(rating))
				.collect(Collectors.toList());
	}
}