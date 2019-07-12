package br.pucrs.maven.sensor.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.pucrs.maven.sensor.model.Sensor;
import br.pucrs.maven.sensor.sensor.SensorRepository;

@RestController
@RequestMapping("/sensors")
public class SensorsRestController {
	@Autowired
	private SensorRepository sensorservice;
	
	@RequestMapping(value = "/{Id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> updateSensor(@PathVariable("Id") int sensorId, Sensor sensor, UriComponentsBuilder ucBuilder){
		Sensor currentsensor = this.sensorservice.findById(sensorId);
		if(currentsensor == null){return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);}
		
		currentsensor.setId(sensor.getId());
		currentsensor.setName(sensor.getName());
		currentsensor.setPlant(sensor.getPlant());
		currentsensor.setTrack(sensor.getTrack());
		currentsensor.setHumidity(sensor.getHumidity());
		
		this.sensorservice.save(currentsensor);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/{Id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> addSensor(@PathVariable("Id") int sensorId){
		Sensor sensor = this.sensorservice.findById(sensorId);
		this.sensorservice.save(sensor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
}

