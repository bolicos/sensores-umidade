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
	
	public Plant() {super();}
	
	@JsonProperty
	@ManyToOne
	@JoinColumn(name = "sensor_id")
    private Sensor idSensor;
	@JsonProperty
	@ManyToOne
	@JoinColumn(name = "type_id")
    private Type type;
	@JsonProperty
	@Column(name = "humidity")
	private Integer humidity;
	@Column(name = "status")
    private String status;
	
	@Column(name = "data_time")
	private LocalDateTime dataTime;
	
	public Plant(Sensor idSensor, Type type, Integer humidity, String status, LocalDateTime dataTime) {
		super();
		this.idSensor = idSensor;
		this.type = type;
		this.humidity = humidity;
		this.status = status;
		this.dataTime = dataTime;
	}
	
	@JsonProperty
	public Sensor getIdSensor() {return idSensor;}
	@JsonProperty
	public void setIdSensor(Sensor idSensor) {this.idSensor = idSensor;}
	
	@JsonProperty
	public Type getType() {return type;}
	@JsonProperty
	public void setType(Type type) {this.type = type;}
	
	@JsonProperty
	public Integer getHumidity() {return humidity;}
	@JsonProperty
	public void setHumidity(Integer humidity) {this.humidity = humidity;}
	
	public String getStatus() {return status;}
	public void setStatus(String status) {this.status = status;}
	
	@JsonProperty
	public LocalDateTime getDataTime() {return dataTime;}
	@JsonProperty
	public void setDataTime(LocalDateTime dataTime) {this.dataTime = dataTime;}

	@Override
	public String toString() {
		return "Plant [idSensor=" + idSensor + ", type=" + type + ", humidity=" + humidity + ", status=" + status
				+ ", dataTime=" + dataTime + ", getId()=" + getId() + ", isNew()=" + isNew() + "]";
	}
		
}
