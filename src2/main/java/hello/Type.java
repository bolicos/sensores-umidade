package hello;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Type {

    private String name;
    private String track;
    private int humidity;
    private boolean status;
    
    public Type() {}
    
    @JsonProperty("sensor")
    public String getTrack() {return track;}
    @JsonProperty("sensor")
	public void setTrack(String track) {this.track = track;}
    
	@JsonProperty("sensor")
	public String getName() {return name;}
	@JsonProperty("sensor")
	public void setName(String name) {this.name = name;}
	
	@JsonProperty("sensor")
	public int getHumidity() {return humidity;}
	@JsonProperty("sensor")
	public void setHumidity(int humidity) {this.humidity = humidity;}
	
	@JsonProperty("sensor")
	public boolean isStatus() {return status;}
	@JsonProperty("sensor")
	public void setStatus(boolean status) {this.status = status;}
    
	public LocalDate getDate() {return null;}

    @Override
    public String toString() {
        return "Type{" + "name=" + name + ", track='" + track + ", humidity='" + humidity + ", status='" + status + '\'' + '}';
    }
	

}