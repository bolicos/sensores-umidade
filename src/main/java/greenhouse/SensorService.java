package greenhouse;

import org.springframework.web.client.RestTemplate;

import greenhouse.models.Sensor;

public class SensorService {
	private RestTemplate restTemplate;

	public SensorService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	
	public Sensor getDataSensor() {
		return restTemplate.getForObject("http://fundatec.dev.aioria.com.br/api/v1/humidity", Sensor.class);
	}
	
	public String getEmail() {
		return restTemplate.getForObject("http://localhost:8080/email-send", String.class);
	}

}
