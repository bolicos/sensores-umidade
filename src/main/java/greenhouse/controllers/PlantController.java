package greenhouse.controllers;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import greenhouse.models.Strawberry;
import greenhouse.repositories.StrawberryRepository;

@Controller
public class PlantController {

	private StrawberryRepository strawberries;
	
	public PlantController(StrawberryRepository strawberrys) {
		super();
		this.strawberries = strawberrys;
	}
	
	@GetMapping("/plants")
	public String listPlants(Model model) {
		Collection<Strawberry> plantsList = strawberries.findAll();	
		model.addAttribute("plants", plantsList);
		return "plantList";
	}
	
	@GetMapping("/plants/{strawberryId}")
    public ModelAndView showStrawberry(@PathVariable("strawberryId") int strawberryId) {
        ModelAndView mav = new ModelAndView("plants/plantDetails");
        mav.addObject(this.strawberries.findById(strawberryId));
        return mav;
    }
	

	
}
