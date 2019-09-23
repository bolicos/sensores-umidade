package greenhouse.controllers;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import greenhouse.models.Read;
import greenhouse.models.Sensor;
import greenhouse.models.Type;
import greenhouse.repositories.PlantRepository;
import greenhouse.repositories.ReadRepository;
import greenhouse.repositories.SensorRepository;
import greenhouse.repositories.TypeRepository;

@Controller
public class PlantController {
	
	private static final String VIEWS_SENSOR_CREATE_OR_UPDATE_FORM = "sensor/createOrUpdateSensortForm";
	private PlantRepository plants;
	private SensorRepository sensors;
	private TypeRepository types;
	private ReadRepository reads;
	
	public PlantController(PlantRepository plants, SensorRepository sensors, TypeRepository types, ReadRepository reads) {
		super();
		this.plants = plants;
		this.sensors = sensors;
		this.types = types;
		this.reads = reads;
	}
	
	@GetMapping("/plants/read")
	public String listReadPlants(Model model) {
		Collection<Read> readList = reads.findAll();
		model.addAttribute("reads", readList);
		return "read/readList";
	}
	
	@GetMapping("/sensors")
	public String listSensors(Model model) {
		Collection<Sensor> sensorList = sensors.findAll();	
		model.addAttribute("sensors", sensorList);
		return "sensor/sensorList";
	}
	@GetMapping("/plants")
	public String listPlants(Model model) {
		Collection<Type> typeList = types.findAll();	
		model.addAttribute("types", typeList);
		return "type/typeList";
	}
	

//------------------------------------------------------------------------------------------===============
//--------------------------------------------------CREATE SENSOR----------------------------------------------
	@PostMapping("/sensors/new")
    public String processcreateSensor(@Valid Sensor sensor, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_SENSOR_CREATE_OR_UPDATE_FORM;
        } else {
            this.sensors.save(sensor);
            return "redirect:/sensors/{sensorId}";
        }
    }
	
	@GetMapping("/sensors/new")
    public String initcreateSensor(Map<String, Object> model) {
		Sensor sensor = new Sensor();
        model.put("sensor", sensor);
        return VIEWS_SENSOR_CREATE_OR_UPDATE_FORM;
    }
//------------------------------------------------------------------------------------------===============
}
