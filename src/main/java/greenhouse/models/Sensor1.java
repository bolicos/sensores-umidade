package greenhouse.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sensor1")
public class Sensor1 extends Sensor{

	private static final long serialVersionUID = 1L;

	
	public Sensor1(Integer id, String name, Integer humidity, String status, Integer trackmin, Integer trackmax,
			LocalDateTime dataTime) {
		super(id, name, humidity, status, trackmin, trackmax, dataTime);
	}
	
	
	public void valid(String email) {
		if((this.getHumidity()>=this.getTrackmin()) & (this.getHumidity()<=this.getTrackmax()))
		{this.setStatus("Normal");}
		else{this.setStatus(email);}
	}
	
	
}