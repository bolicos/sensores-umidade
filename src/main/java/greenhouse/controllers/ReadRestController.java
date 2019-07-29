package greenhouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import greenhouse.models.Read;
import greenhouse.repositories.ReadRepository;
import greenhouse.services.ReadService;

@RestController
@RequestMapping("/plants")
public class ReadRestController {
	
	@Autowired
	private ReadRepository readRepository;
	
	@Autowired
	private ReadService readservice;

	@RequestMapping(value = "/read", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Read> addRead(@RequestBody Read read) {
		try{
			
			this.readRepository.save(this.readservice.saveRead(read));
			return new ResponseEntity<Read>(read, HttpStatus.CREATED);
		} catch (Exception notCreated){
			return new ResponseEntity<Read>(read, HttpStatus.BAD_REQUEST);
		}
		
	}
	
}

