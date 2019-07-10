package org.springframework.samples.petclinic.sensor;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SensorController {	
	private SensorRepository sensors;
	
	public SensorController(SensorRepository sensors) {
		super();
		this.sensors = sensors;
	}
	
	@GetMapping("/sensors")
    public String processFindForm(Model model) {
		Collection<Sensor> sensorsList = sensors.findAll();	
		model.addAttribute("sensors", sensorsList);
        return "sensors/sensorsList";
    }
	
	@GetMapping("/sensors/{sensorId}")
	public ModelAndView showSensors(@PathVariable("sensorId") int sensorId) {
        ModelAndView mav = new ModelAndView("sensors/sensorDetails");
        mav.addObject(this.sensors.findById(sensorId));
        return mav;	
	}
    
}
