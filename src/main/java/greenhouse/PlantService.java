package greenhouse;

import org.springframework.web.client.RestTemplate;

import greenhouse.models.Type;
import greenhouse.repositories.TypeRepository;

public class PlantService {
	private RestTemplate restTemplate;
	private Type type;
	private TypeRepository types;
	
	public PlantService() {
		super();
	}
	
	public PlantService(RestTemplate restTemplate, Type t) {
		super();
		this.restTemplate = restTemplate;
		this.type = t;
	}

	public Integer FilterType(Integer id) {
		this.type = types.findById(id);
		return this.type.getId();
	}
	
	public String getEmail() {
		return restTemplate.getForObject("http://localhost:8080/email-send", String.class);
	}

}
