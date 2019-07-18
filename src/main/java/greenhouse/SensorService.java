package greenhouse;

import org.springframework.web.client.RestTemplate;

public class SensorService {
	private RestTemplate restTemplate;

	public SensorService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	
	public String getEmail() {
		return restTemplate.getForObject("http://localhost:8080/email-send", String.class);
	}

}
