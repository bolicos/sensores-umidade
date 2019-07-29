package greenhouse.repositories;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import greenhouse.models.Sensor;

public interface SensorRepository extends Repository<Sensor, Integer>{
	Collection<Sensor> findAll() throws DataAccessException;
	Sensor findById(Integer id) throws DataAccessException;
	Sensor findById(Sensor idSensor) throws DataAccessException;
	
	public void save(Sensor sensor) throws DataAccessException;
	public void delete(Sensor sensor) throws DataAccessException;
	
}
