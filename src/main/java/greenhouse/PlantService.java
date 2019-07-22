package greenhouse;

import org.springframework.web.client.RestTemplate;

import greenhouse.models.Type;
import greenhouse.repositories.PlantRepository;
import greenhouse.repositories.SensorRepository;
import greenhouse.repositories.TypeRepository;

public class PlantService {
	private RestTemplate restTemplate;
	private Type type;
	private TypeRepository types;
	private PlantRepository plants;
	private SensorRepository sensors;
	
	public PlantService() {
		super();
	}
	
	public PlantService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}
	public PlantService(TypeRepository t, PlantRepository p, SensorRepository s ) {
		super();
		this.types = t;
		this.plants = p;
		this.sensors = s;
		
	}

	public Integer FilterType(Integer id) {
		this.type = types.findById(id);
		return this.type.getId();
	}
	
	public String getEmail() {
		return restTemplate.getForObject("http://localhost:8080/email-send", String.class);
	}

}


