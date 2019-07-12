package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.sensor.Sensor;
import org.springframework.samples.petclinic.sensor.SensorRepository;
import org.springframework.stereotype.Service;

@Service
public class SensorServiceImpl implements SensorService {
	
	@Autowired
	private SensorRepository sensorRepository;
	
	@Override
	public Sensor findById(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return sensorRepository.findById(id);
	}

	@Override
	public Collection<Sensor> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return sensorRepository.findAll();
	}

	@Override
	public void saveSensor(Sensor sensor) throws DataAccessException {
		sensorRepository.save(sensor);
		
	}

	@Override
	public void deleteSensor(Sensor sensor) throws DataAccessException {
		sensorRepository.delete(sensor);
		
	}
	

}
