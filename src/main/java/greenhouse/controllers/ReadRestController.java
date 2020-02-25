package greenhouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import greenhouse.models.Read;
import greenhouse.repositories.ReadRepository;
import greenhouse.services.ReadService;

@RestController
@RequestMapping("/v1/plants")
public class ReadRestController {
	
	private ReadRepository readRepository;
	private ReadService readservice;

	@Autowired
	public ReadRestController(ReadService readService, ReadRepository readRepository) {
		this.readservice = readService;
		this.readRepository = readRepository;
	}

	@PostMapping(value = "/read", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Read> addRead(@RequestBody Read read) {
		try{
			this.readRepository.save(this.readservice.saveRead(read));
			return new ResponseEntity<>(read, HttpStatus.CREATED);
		} catch (Exception notCreated){
			return new ResponseEntity<>(read, HttpStatus.BAD_REQUEST);
		}
		
	}
	
}

