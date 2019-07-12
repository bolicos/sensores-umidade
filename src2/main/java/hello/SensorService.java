package hello;

import org.springframework.web.client.RestTemplate;

public class SensorService {
	private RestTemplate restTemplate;

	public SensorService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	public Sensor getSensor() {
		return restTemplate.getForObject(
				"http://fundatec.dev.aioria.com.br/api/v1/humidity", Sensor.class);
	}

}
