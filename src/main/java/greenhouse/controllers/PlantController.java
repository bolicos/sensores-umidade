package greenhouse.controllers;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import greenhouse.models.Plant;
import greenhouse.repositories.PlantRepository;

@Controller
public class PlantController {

	private PlantRepository plants;
	
	public PlantController(PlantRepository plants) {
		super();
		this.plants = plants;
	}
	
	@GetMapping("/plants")
	public String listPlants(Model model) {
		Collection<Plant> plantsList = plants.findAll();	
		model.addAttribute("plants", plantsList);
		return "plantList";
	}
	
	@GetMapping("/plants/{plantId}")
    public ModelAndView showStrawberry(@PathVariable("plantId") int plantId) {
        ModelAndView mav = new ModelAndView("plants/plantDetails");
        mav.addObject(this.plants.findById(plantId));
        return mav;
    }
	

	
}
