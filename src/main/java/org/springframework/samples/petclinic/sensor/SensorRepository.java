package org.springframework.samples.petclinic.sensor;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

public interface SensorRepository extends Repository<Sensor, Integer> {

	Collection<Sensor> findAll() throws DataAccessException;
	
	Sensor findById(Integer id) throws DataAccessException;
	
	void save(Sensor sensor) throws DataAccessException;
	
	void delete(Sensor sensor) throws DataAccessException;
}
