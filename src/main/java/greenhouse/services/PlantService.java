package greenhouse.services;

import greenhouse.dtos.PlantDto;
import greenhouse.models.Plant;
import greenhouse.repositories.PlantRepository;
import org.springframework.stereotype.Service;

@Service
public class PlantService {

    private PlantRepository repository;

    public PlantService(PlantRepository repository) {
        this.repository = repository;
    }

    public String create(PlantDto plantDto) {
        Plant plant = new Plant();
        this.repository.save(plant);
        return "ok";
    }
}
