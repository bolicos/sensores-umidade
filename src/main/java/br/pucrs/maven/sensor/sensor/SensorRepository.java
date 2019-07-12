package br.pucrs.maven.sensor.sensor;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import br.pucrs.maven.sensor.model.Sensor;

public interface SensorRepository extends Repository<Sensor, Integer> {
	Sensor findById(Integer id) throws DataAccessException;
	Collection<Sensor> findAll() throws DataAccessException;
	public void save(Sensor sensor) throws DataAccessException;
	public void delete(Sensor sensor) throws DataAccessException;
}
