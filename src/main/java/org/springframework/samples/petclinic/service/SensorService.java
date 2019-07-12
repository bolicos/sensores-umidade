package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.sensor.Sensor;

public interface SensorService {
	
	Sensor findById(int id) throws DataAccessException;
	Collection<Sensor> findAll() throws DataAccessException;
	public void saveSensor(Sensor sensor) throws DataAccessException;
	public void deleteSensor(Sensor sensor) throws DataAccessException;
}
