package greenhouse.repositories;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import greenhouse.models.Plant;

public interface PlantRepository extends Repository<Plant, Integer>{
	
	Collection<Plant> findAll() throws DataAccessException;
	Plant findById(Integer id) throws DataAccessException;
	
	void savePlant(Plant plant) throws DataAccessException;
	void deletePlant(Plant plant) throws DataAccessException;
}
