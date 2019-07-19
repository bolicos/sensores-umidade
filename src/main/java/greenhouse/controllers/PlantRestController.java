package greenhouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Plant> updateType(@PathVariable("id") Integer id,@RequestBody Plant plant) {
		
		Plant currentPlant = this.plantRepository.findById(id);
		if (currentPlant == null) {
			return new ResponseEntity<Plant>(HttpStatus.NOT_FOUND);
		}
		currentPlant.setDataTime(plant.getDataTime());
		currentPlant.setHumidity(plant.getHumidity());
		currentPlant.setId(plant.getId());
		currentPlant.setIdSensor(plant.getIdSensor());
		
		this.plantRepository.save(currentPlant);
		return new ResponseEntity<Plant>(currentPlant, HttpStatus.NO_CONTENT);
	}
	
}
