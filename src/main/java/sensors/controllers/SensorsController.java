package sensors.controllers;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import sensors.models.Sensor;

@Controller
public class SensorsController {
	
	private Sensor sensors;
	
	public SensorsController(Sensor sensors) {this.sensors = sensors;}
	
	@GetMapping("/sensors")
    public String processFindForm(Model model) {
		Collection<Sensor> sensorsList = sensors.findAll();	
		model.addAttribute("sensors", sensorsList);
        return "sensors/sensorsView";
    }
	
	@GetMapping("/sensors/{sensorId}")
	public ModelAndView showSensors(@PathVariable("sensorId") int sensorId) {
        ModelAndView sen = new ModelAndView("sensors/SensorDetails");
        sen.addObject(this.sensors.findById(sensorId));
        return sen;	
	}
    

	
    
}
