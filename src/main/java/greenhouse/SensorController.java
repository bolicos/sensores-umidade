package greenhouse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SensorController {

	private static final Logger log = LoggerFactory.getLogger(SensorController.class);

	@Autowired
	private SensorService svc;

	@GetMapping("/")
	public String showSensor(Model model) {
		Sensor sensor = svc.getDataSensor();
		
		if((sensor.getHumidity()>=60) & (sensor.getHumidity()<=80)) {sensor.setStatus("Normal");}
		else{sensor.setStatus(svc.getEmail());}
		log.info(sensor.toString());
	
		model.addAttribute("s", sensor);
		return "sensorDetails";
	}
	

}
