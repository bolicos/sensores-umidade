package org.springframework.samples.petclinic.sensor;

import java.util.Collection;

import org.springframework.data.repository.Repository;

public interface SensorRepository extends Repository<Sensor, Integer> {

	Collection<Sensor> findAll();

	Sensor findById(Integer id);

}
