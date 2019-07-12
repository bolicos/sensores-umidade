package sensors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.sensor.Sensor;
import org.springframework.samples.petclinic.sensor.SensorService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SensorsRestController {
	@Autowired
	private SensorService sensorservice;
	
	@RequestMapping(value = "/sensors/{sensorId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> updateSensor(@PathVariable("sensorId") int sensorId){
		Sensor sensor = this.sensorservice.findById(sensorId);
		if(sensor == null){return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);}
		this.sensorservice.saveSensor(sensor);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/sensors/{sensorId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> addSensor(@PathVariable("sensorId") int sensorId){
		Sensor sensor = this.sensorservice.findById(sensorId);
		this.sensorservice.saveSensor(sensor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
}
