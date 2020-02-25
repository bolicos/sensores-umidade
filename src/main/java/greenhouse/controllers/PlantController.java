package greenhouse.controllers;

import greenhouse.dtos.SensorDto;
import greenhouse.dtos.SensorProjection;
import greenhouse.models.Read;
import greenhouse.models.Type;
import greenhouse.repositories.PlantRepository;
import greenhouse.repositories.ReadRepository;
import greenhouse.repositories.TypeRepository;
import greenhouse.services.SensorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
public class PlantController {

	private PlantRepository plants;
	private SensorService service;
	private TypeRepository types;
	private ReadRepository reads;
	

	
	@GetMapping("/plants/read")
	public String listReadPlants(Model model) {
		Collection<Read> readList = reads.findAll();
		model.addAttribute("reads", readList);
		return "read/readList";
	}
	
	@GetMapping("/sensors")
	public String listSensors(Model model) {
		List<SensorProjection> sensorList = this.service.findAll();
		model.addAttribute("sensors", sensorList);
		return "sensor/sensorList";
	}
	@GetMapping("/plants")
	public String listPlants(Model model) {
		Collection<Type> typeList = types.findAll();	
		model.addAttribute("types", typeList);
		return "type/typeList";
	}
	
	@PostMapping("/sensors/new")
    public ResponseEntity<String> create(@Valid SensorDto sensor) {
		this.service.create(sensor);
		return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
