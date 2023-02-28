package com.brv.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.brv.model.Movie;
import com.brv.model.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	public MovieResource() {
		// TODO Auto-generated constructor stub
	}
	
	@Value("${api.key}")
	private String apiKey;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId")String movieId) {
		
		String url = "https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apiKey+"&language=en-US";
		System.out.println("-----------------------------");
		System.out.println("url:: " + url);
		System.out.println("----------------------");
		MovieSummary movieSummary = restTemplate.getForObject(url, MovieSummary.class);
		System.out.println("url:: " + url);
		return new Movie(movieId,movieSummary.getTitle(),movieSummary.getOverview());
	}
}
