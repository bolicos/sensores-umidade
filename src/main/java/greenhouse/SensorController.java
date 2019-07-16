package greenhouse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import greenhouse.models.Sensor;

@Controller
public class SensorController {

	private static final Logger log = LoggerFactory.getLogger(SensorController.class);

	@Autowired
	private SensorService svc;

	@GetMapping("/")
	public ModelAndView showSensor(ModelAndView model) {
		Sensor sensor1 = svc.getDataSensor();
		Sensor sensor2 = svc.getDataSensor();
		Sensor sensor3 = svc.getDataSensor();
		Sensor sensor4 = svc.getDataSensor();
		Sensor sensor5 = svc.getDataSensor();
		
		log.info(sensor1.toString());
		//log.info(sensor2.toString());
		//log.info(sensor3.toString());
		//log.info(sensor4.toString());
		//log.info(sensor5.toString());
		
		//sensor1.valid(svc.getEmail());
		//sensor2.valid();
		//sensor3.valid();
		//sensor4.valid();
		//sensor5.valid();
		
		model.addObject("s1", sensor1);
		model.addObject("s2", sensor2);
		model.addObject("s3", sensor3);
		model.addObject("s4", sensor4);
		model.addObject("s5", sensor5);
		
		model.setViewName("sensorDetails");
		
		return model;
	}

}
