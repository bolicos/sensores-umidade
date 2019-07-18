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

import greenhouse.models.Strawberry;
import greenhouse.repositories.StrawberryRepository;

@RestController
@RequestMapping("/plants")
public class PlantRestController {
	
	@Autowired
	private StrawberryRepository strawberryrepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Strawberry> updateType(@PathVariable("id") Integer id,@RequestBody Strawberry strawberry) {
		
		Strawberry currentStrawberry = this.strawberryrepository.findById(id);
		if (currentStrawberry == null) {
			return new ResponseEntity<Strawberry>(HttpStatus.NOT_FOUND);
		}
		currentStrawberry.setDataTime(strawberry.getDataTime());
		currentStrawberry.setHumidity(strawberry.getHumidity());
		currentStrawberry.setId(strawberry.getId());
		currentStrawberry.setIdsensor(strawberry.getIdsensor());
		
		this.strawberryrepository.save(currentStrawberry);
		return new ResponseEntity<Strawberry>(currentStrawberry, HttpStatus.NO_CONTENT);
	}
	
}
