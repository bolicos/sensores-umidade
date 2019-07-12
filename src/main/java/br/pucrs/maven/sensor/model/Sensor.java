package br.pucrs.maven.sensor.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "sensors")
public class Sensor extends NamedEntity {
	private static final long serialVersionUID = 1L;
	
	private String plant;
	private String track;
	private int humidity;

	public String getTrack() {return track;}
	public void setTrack(String track) {this.track = track;}

	public String getPlant() {return plant;}
	public void setPlant(String plant) {this.plant = plant;}
	
	public int getHumidity() {return humidity;}
	public void setHumidity(int humidity) {this.humidity = humidity;}
	
	
	@Override
    public String toString() {
        return new ToStringCreator(this)

            .append("id", this.getId())
            .append("name", this.getName())
            .append("plant", this.getPlant())
            .append("track", this.getTrack())
            .append("humidity", this.getHumidity())

            .toString();
    }
}