package greenhouse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sensor3 {
private static final Logger log = LoggerFactory.getLogger(Sensor2.class);

	
	private int id;
    private int humidity;
    private String status;
    private int trackmin = 80;
    private int trackmax = 90;

	public Sensor3() {}
    
    @JsonProperty
    public int getId() {return id;}
    @JsonProperty
    public void setId(int id) {this.id = id;}
    @JsonProperty
    public int getHumidity() {return humidity;}
    @JsonProperty
	public void setHumidity(int humidity) {this.humidity = humidity;}
    
    public String getStatus() {return status;}
	public void setStatus(String status) {this.status = status;}

	public int getTrackmin() {return trackmin;}
	public void setTrackmin(int trackmin) {this.trackmin = trackmin;}

	public int getTrackmax() {return trackmax;}
	public void setTrackmax(int trackmax) {this.trackmax = trackmax;}
	
	public void valid(String email) {
		if((this.humidity>=trackmin) & (this.humidity<=trackmax))
		{setStatus("Normal");}
		else{setStatus(email);}
		log.info(this.toString());
	}
	
	@Override
	public String toString() {
		return "Sensor3 [id=" + id + ", humidity=" + humidity + ", status=" + status + "]";
	}
}
