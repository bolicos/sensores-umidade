package greenhouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import greenhouse.models.Plant;
import greenhouse.repositories.PlantRepository;

@RestController
@RequestMapping("/plants")
public class PlantRestController {
	
	@Autowired
	private PlantRepository plantRepository;

	@RequestMapping(value = "/read", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Plant> addRead(@RequestBody Plant plant) {
		try{
			this.plantRepository.save(plant);
			return new ResponseEntity<Plant>(plant, HttpStatus.CREATED);
		} catch (Exception notCreated){
			return new ResponseEntity<Plant>(plant, HttpStatus.BAD_REQUEST);
		}
		
	}
	
}

