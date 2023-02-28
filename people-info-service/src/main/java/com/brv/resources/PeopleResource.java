package com.brv.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.brv.models.People;
import com.brv.models.PeopleSummary;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/peoples")
public class PeopleResource {

	public PeopleResource() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Value("${api.key}")
	private String apiKey;

	
	@Autowired
	RestTemplate restTemplate;
	
	
	@RequestMapping("/{peopleId}")
	public People getPeopleInfo(@PathVariable("peopleId") String peopleId) {
		String url = "https://api.themoviedb.org/3/person/"+peopleId+"?api_key="+apiKey+"&language=en-US";
		PeopleSummary ps = restTemplate.getForObject(url, PeopleSummary.class);
		return new People(peopleId,ps.getName(),ps.getBiography());
	}
	
}
