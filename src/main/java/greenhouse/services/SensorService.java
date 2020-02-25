package greenhouse.services;

import greenhouse.dtos.SensorDto;
import greenhouse.dtos.SensorProjection;
import greenhouse.models.Sensor;
import greenhouse.repositories.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    private SensorRepository repository;

    public SensorService(SensorRepository repository) {
        this.repository = repository;
    }

    public List<SensorProjection> findAll() {
        return this.repository.findAllByStatusTrueOrderByName();
    }

    public boolean create(SensorDto sensorDto) {
        Long id = this.repository.save(new Sensor()).getId();
        return this.repository.existsById(id);
    }
}
