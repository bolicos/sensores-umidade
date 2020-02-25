package greenhouse.services;

import greenhouse.models.Read;
import greenhouse.models.Sensor;
import greenhouse.repositories.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReadService implements IReadService{
	private SensorRepository repository;

	public ReadService(SensorRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Read saveRead(Read read) {
		Long id = read.getIdSensor().getId();
		Optional<Sensor> sensor = this.repository.findById(id);
		sensor.ifPresent(read::setIdSensor);
		return read;
	}
}
