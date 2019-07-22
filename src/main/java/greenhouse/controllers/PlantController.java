package greenhouse.controllers;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import greenhouse.models.Plant;
import greenhouse.models.Sensor;
import greenhouse.models.Type;
import greenhouse.repositories.PlantRepository;
import greenhouse.repositories.SensorRepository;
import greenhouse.repositories.TypeRepository;

@Controller
public class PlantController {

	private PlantRepository plants;
	private SensorRepository sensors;
	private TypeRepository types;
	
	public PlantController(PlantRepository plants, SensorRepository sensors, TypeRepository types) {
		super();
		this.plants = plants;
		this.sensors = sensors;
		this.types = types;
	}
	
	@GetMapping("/read")
	public String listPlants(Model model) {
		Collection<Plant> readList = plants.findAll();	
		model.addAttribute("plants", readList);
		return "readList";
	}
	
	@GetMapping("/sensors")
	public String listSensors(Model model) {
		Collection<Sensor> sensorList = sensors.findAll();	
		model.addAttribute("sensors", sensorList);
		return "sensorList";
	}
	@GetMapping("/types")
	public String listTypes(Model model) {
		Collection<Type> typeList = types.findAll();	
		model.addAttribute("types", typeList);
		return "typeList";
	}
	
	@GetMapping("/plants/{plantId}")
    public ModelAndView showPlant(@PathVariable("plantId") int plantId) {
        ModelAndView mav = new ModelAndView("plantDetails");
        mav.addObject(this.plants.findAll());
        return mav;
    }
	

	
}
