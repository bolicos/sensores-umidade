package greenhouse.repositories;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import greenhouse.models.Plant;

public interface PlantRepository extends Repository<Plant, Integer>{
	Collection<Plant> findAll() throws DataAccessException;
	Plant findById(Integer id) throws DataAccessException;
	
	@Query("SELECT sen FROM Plant sen WHERE sen.idSensor.id = ?1")
	Collection<Plant> findBySensor(@Param("id") Integer id);
	
	@Query("SELECT plan FROM Plant plan WHERE plan.type.id = ?1")
	Collection<Plant> findByType(@Param("id") Integer id);
	
	public void save(Plant plant) throws DataAccessException;
	public void delete(Plant plant) throws DataAccessException;
	
}

