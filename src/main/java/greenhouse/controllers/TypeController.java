package greenhouse.controllers;

import greenhouse.dtos.PlantDto;
import greenhouse.services.PlantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TypeController {
	
	private PlantService service;

	public TypeController(PlantService service) {
		this.service = service;
	}

	@PostMapping("/plants/new")
	public ResponseEntity<String> processcreateTypePlant(@Valid PlantDto plant) {
		this.service.create(plant);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
