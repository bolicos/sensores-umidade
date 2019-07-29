package greenhouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import greenhouse.models.Read;
import greenhouse.models.Sensor;
import greenhouse.repositories.SensorRepository;

@Service
public class ReadServiceimpl implements ReadService{
	private SensorRepository sensorrepository;
	private Sensor sensor;

	@Autowired
	public ReadServiceimpl(SensorRepository sensorrepository) {
		this.sensorrepository = sensorrepository;
	}
	
	@Override
	public Read saveRead(Read read) throws DataAccessException{
		this.sensor = sensorrepository.findById(read.getIdSensor().getId());
		read.setIdSensor(this.sensor);
		return read;
	}
}
