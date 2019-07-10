package org.springframework.samples.petclinic.sensor;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.samples.petclinic.model.NamedEntity;

@Entity
@Table(name = "sensors")
public class Sensor extends NamedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String plant;
	private String track;
	

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

}
