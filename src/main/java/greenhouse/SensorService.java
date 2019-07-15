package greenhouse;

import org.springframework.web.client.RestTemplate;

public class SensorService {
	private RestTemplate restTemplate;

	public SensorService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	public Sensor1 getDataSensor1() {
		return restTemplate.getForObject("http://fundatec.dev.aioria.com.br/api/v1/humidity", Sensor1.class);
	}
	public Sensor2 getDataSensor2() {
		return restTemplate.getForObject("http://fundatec.dev.aioria.com.br/api/v1/humidity", Sensor2.class);
	}
	public Sensor3 getDataSensor3() {
		return restTemplate.getForObject("http://fundatec.dev.aioria.com.br/api/v1/humidity", Sensor3.class);
	}
	public Sensor4 getDataSensor4() {
		return restTemplate.getForObject("http://fundatec.dev.aioria.com.br/api/v1/humidity", Sensor4.class);
	}
	public Sensor5 getDataSensor5() {
		return restTemplate.getForObject("http://fundatec.dev.aioria.com.br/api/v1/humidity", Sensor5.class);
	}
	
	public String getEmail() {
		return restTemplate.getForObject("http://localhost:8080/email-send", String.class);
	}

}
