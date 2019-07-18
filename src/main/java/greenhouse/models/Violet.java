package greenhouse.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "violets")
public class Violet extends Plant{
	private static final long serialVersionUID = 1L;
	
	public Violet(Integer id, Integer idsensor, String name, Integer humidity, String status, Integer trackmin,
			Integer trackmax, LocalDateTime dataTime) {
		super(id, idsensor, name, humidity, status, trackmin, trackmax, dataTime);
	}

	public void setTrackmin() {super.setTrackmin(40);}
	public void setTrackmax() {super.setTrackmin(80);}

	public void valid(String email) {
		if((this.getHumidity()>=this.getTrackmin()) & (this.getHumidity()<=this.getTrackmax()))
		{this.setStatus("Normal");}
		else{this.setStatus(email);}
	}
}