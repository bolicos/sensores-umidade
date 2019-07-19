package greenhouse.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "plants")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Plant extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	public Plant(Sensor idSensor, Type type, Integer humidity, String status, Integer trackmin, Integer trackmax,
			LocalDateTime dataTime) {
		super();
		this.idSensor = idSensor;
		this.type = type;
		this.humidity = humidity;
		this.status = status;
		this.trackmin = trackmin;
		this.trackmax = trackmax;
		this.dataTime = dataTime;
	}
	
	@JsonProperty
	@ManyToOne
	@JoinColumn(name = "sensor_id")
    private Sensor idSensor;
	@JsonProperty
	@ManyToOne
	@JoinColumn(name = "type_id")
    private Type type;
	@Column(name = "humidity")
	private Integer humidity;
	@Column(name = "status")
    private String status;
	@Column(name = "trackmin")
    private Integer trackmin;
	@Column(name = "trackmax")
    private Integer trackmax;
	@Column(name = "data_time")
	private LocalDateTime dataTime;
	
	@JsonProperty
	public Sensor getIdSensor() {return idSensor;}
	@JsonProperty
	public void setIdSensor(Sensor idSensor) {this.idSensor = idSensor;}
	
	@JsonProperty
	public Integer getHumidity() {return humidity;}
	@JsonProperty
	public void setHumidity(Integer humidity) {this.humidity = humidity;}
	
	public String getStatus() {return status;}
	public void setStatus(String status) {this.status = status;}
	
	public Integer getTrackmin() {return trackmin;}
	public void setTrackmin(Integer trackmin) {this.trackmin = trackmin;}
	
	public Integer getTrackmax() {return trackmax;}
	public void setTrackmax(Integer trackmax) {this.trackmax = trackmax;}
	
	public LocalDateTime getDataTime() {return dataTime;}
	public void setDataTime(LocalDateTime dataTime) {this.dataTime = dataTime;}

	@Override
	public String toString() {
		return "Plant [idSensor=" + idSensor + ", type=" + type + ", humidity=" + humidity + ", status=" + status
				+ ", trackmin=" + trackmin + ", trackmax=" + trackmax + ", dataTime=" + dataTime + ", getId()="
				+ getId() + ", isNew()=" + isNew() + "]";
	}
	
		
}
