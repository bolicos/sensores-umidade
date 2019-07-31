package greenhouse.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import greenhouse.models.Type;
import greenhouse.repositories.TypeRepository;

@Controller
public class TypeController {
	private static final String VIEWS_PLANT_CREATE_OR_UPDATE_FORM = "plant/createOrUpdatePlantForm";
	
	private TypeRepository types;
	//----------------------------------------------CREATE PLANT TYPE----------------------------------------------
		@PostMapping("/plants/new")
	    public String processcreateTypePlant(@Valid Type type, BindingResult result) {
	        if (result.hasErrors()) {
	            return VIEWS_PLANT_CREATE_OR_UPDATE_FORM;
	        } else {
	            this.types.save(type);
	            return "redirect:/plants/{plantId}";
	        }
	    }
		
		@GetMapping("/plants/new")
	    public String initcreateTypePlant(Map<String, Object> model) {
			Type type = new Type();
	        model.put("type", type);
	        return VIEWS_PLANT_CREATE_OR_UPDATE_FORM;
	    }
}
