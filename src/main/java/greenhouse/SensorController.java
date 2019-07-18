package greenhouse;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import greenhouse.models.Plant;
import greenhouse.repositories.PlantRepository;

@Controller
public class SensorController {

private final PlantRepository plants;
	
	public SensorController(PlantRepository plantservice) {
		this.plants = plantservice;
	}

	@GetMapping("/")
	public ModelAndView showSensor(ModelAndView model) {
		Collection<Plant> plant = plants.findAll();
		model.addObject("p", plant);
		model.setViewName("sensorDetails");
		return model;
	}

}
