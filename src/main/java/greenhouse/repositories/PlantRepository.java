package greenhouse.repositories;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import greenhouse.models.Plant;

public interface PlantRepository extends Repository<Plant, Integer>{
	Collection<Plant> findAll() throws DataAccessException;
	Plant findById(@Param("id") Integer id) throws DataAccessException;
	public Plant findById(@Param("id") Plant plant);
	
	public void save(Plant plant) throws DataAccessException;
	public void delete(Plant plant) throws DataAccessException;
	
	
}

