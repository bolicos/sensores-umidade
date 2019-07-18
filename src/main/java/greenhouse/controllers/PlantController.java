package greenhouse.controllers;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import greenhouse.models.Plant;
import greenhouse.repositories.PlantRepository;

@Controller
public class PlantController {

	private final PlantRepository plants;
	
	public PlantController(PlantRepository plantservice) {
		this.plants = plantservice;
	}
	
	@GetMapping("/plants")
    public String processFindForm(Plant plant, BindingResult result, Map<String, Object> model) {

        // allow parameterless GET request for /plants to return all records
        if (plant.getId() == null) {
        	plant.setId(null); // empty string signifies broadest possible search
        }

        // find plants by name
        Collection<Plant> results = this.plants.findByName(plant.getName());
        if (results.isEmpty()) {
            // no plant found
            result.rejectValue("name", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            // 1 plant found
        	plant = results.iterator().next();
            return "redirect:/plants/" + plant.getId();
        } else {
            // multiple plants found
            model.put("selections", results);
            return "plants/plantsList";
        }
    }
	
	@GetMapping("/plants/{plantId}")
    public ModelAndView showPlant(@PathVariable("plantId") int plantId) {
        ModelAndView mav = new ModelAndView("plants/plantDetails");
        mav.addObject(this.plants.findById(plantId));
        return mav;
    }
	
}
