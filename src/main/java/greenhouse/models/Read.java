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
@Table(name = "reads")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Read extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	public Read() {super();}
	
	@JsonProperty
	@ManyToOne
	@JoinColumn(name = "sensor_id")
    private Sensor idSensor;
	
	@JsonProperty
	@Column(name = "humidity")
	private Integer humidity;
	
	@Column(name = "status")
    private Boolean status;
	
	@JsonProperty
	@Column(name = "date_time")
	private LocalDateTime dateTime;
	
	public Sensor getIdSensor() {return idSensor;}
	public void setIdSensor(Sensor idSensor) {this.idSensor = idSensor;}

	public Integer getHumidity() {return humidity;}
	public void setHumidity(Integer humidity) {this.humidity = humidity;}

	public Boolean getStatus() {return status;}
	public void setStatus(Boolean status) {this.status = status;}

	public LocalDateTime getDateTime() {return dateTime;}
	public void setDateTime(LocalDateTime dateTime) {this.dateTime = dateTime;}
	
	@Override
	public String toString() {
		return "Read [idSensor=" + idSensor + ", humidity=" + humidity + ", status=" + status + ", dateTime=" + dateTime
				+ ", getId()=" + getId() + ", isNew()=" + isNew() + "]";
	}
	
}
