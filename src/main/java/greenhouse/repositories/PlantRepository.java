package greenhouse.repositories;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import greenhouse.models.Plant;
import greenhouse.models.Type;

public interface PlantRepository extends Repository<Plant, Integer>{
	Collection<Plant> findAll() throws DataAccessException;
	Plant findById(Integer id) throws DataAccessException;
	Collection<Plant> findByType(Type type) throws DataAccessException;
	
	public void save(Plant plant) throws DataAccessException;
	public void delete(Plant plant) throws DataAccessException;
}
