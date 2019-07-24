package greenhouse;

import greenhouse.models.Type;
import greenhouse.repositories.PlantRepository;
import greenhouse.repositories.SensorRepository;
import greenhouse.repositories.TypeRepository;

public class PlantService {
	private Type type;
	private TypeRepository types;
	private PlantRepository plants;
	private SensorRepository sensors;
	
	public PlantService() {
		super();
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
	

}


