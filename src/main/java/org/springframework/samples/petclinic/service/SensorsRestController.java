package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.sensor.Sensor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/sensors")
@CrossOrigin("${origin-allowed}")
public class SensorsRestController {
	@Autowired
	private SensorService sensorservice;
	
	@RequestMapping(value = "/{sensorId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> updateSensor(@PathVariable("sensorId") int sensorId, Sensor sensor, UriComponentsBuilder ucBuilder){
		Sensor currentsensor = this.sensorservice.findById(sensorId);
		if(currentsensor == null){return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);}
		/*
		currentsensor.setId(sensor.getId());
		currentsensor.setName(sensor.getName());
		currentsensor.setPlant(sensor.getPlant());
		currentsensor.setTrack(sensor.getTrack());
		currentsensor.setHumidity(sensor.getHumidity());
		*/
		this.sensorservice.saveSensor(currentsensor);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/{sensorId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> addSensor(@PathVariable("sensorId") int sensorId){
		Sensor sensor = this.sensorservice.findById(sensorId);
		this.sensorservice.saveSensor(sensor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
}

