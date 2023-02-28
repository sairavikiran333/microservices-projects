package com.brv;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pathology")
public class PathologyResource {

	public PathologyResource() {
		// TODO Auto-generated constructor stub
	}
	
	List<Disease> diseases = Arrays.asList(
			new Disease("D1", "Astma", "Warm water bath"),
			new Disease("D2", "HeadAche", "Hot water vapour"),
			new Disease("D3", "Corona", "Wash your hands reg"));
	
	
	@RequestMapping("/diseases")
	public DiseaseList getDiseases() {
		DiseaseList dl = new DiseaseList();
		dl.setDiseases(diseases);
		return dl;
	}
	
	@RequestMapping("/diseases/{id}")
	public Disease getEmployeeById(@PathVariable("id") String id) {
		Disease disease = diseases.stream().filter(d->id.equals(d.getId())).
				findAny().orElse(null);
		return disease;
	}
	

}
