package greenhouse.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "strawberries")
public class Strawberry extends Plant{
	private static final long serialVersionUID = 1L;

	public Strawberry(Integer id, Integer idsensor, Integer humidity, String status, Integer trackmin, Integer trackmax,
			LocalDateTime dataTime) {
		super(id, idsensor, humidity, status, trackmin, trackmax, dataTime);
	}
	
	public void setTrackmin() {super.setTrackmin(60);}
	public void setTrackmax() {super.setTrackmin(80);}
	
	public void valid(String email) {
		if((this.getHumidity()>=this.getTrackmin()) & (this.getHumidity()<=this.getTrackmax()))
		{this.setStatus("Normal");}
		else{this.setStatus(email);}
	}	
}