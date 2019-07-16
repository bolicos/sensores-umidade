package greenhouse.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@MappedSuperclass
public class Sensor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty
    private Integer id;
	@Column(name = "name")
    private String name;
	@JsonProperty
	@Column(name = "humidity")
	private Integer humidity;
	@Column(name = "status")
    private String status;
	@Column(name = "trackmin")
    private Integer trackmin;
	@Column(name = "trackmax")
    private Integer trackmax;
	@Column(name = "dataTime")
	private LocalDateTime dataTime;
	
	public Sensor(Integer id, String name, Integer humidity, String status, Integer trackmin, Integer trackmax,
			LocalDateTime dataTime) {
		super();
		this.id = id;
		this.name = name;
		this.humidity = humidity;
		this.status = status;
		this.trackmin = trackmin;
		this.trackmax = trackmax;
		this.dataTime = dataTime;
	}
	@JsonProperty
	public Integer getId() {return id;}
	@JsonProperty
	public void setId(Integer id) {this.id = id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
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
		return "Sensor [id=" + id + ", humidity=" + humidity + "]";
	}
	
	
}
