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

@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
public class Plant implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty
    private Integer id;
	@JsonProperty
	@Column(name = "idsensor")
    private Integer idsensor;
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
	
	public Plant(Integer id, Integer idsensor, Integer humidity, String status, Integer trackmin, Integer trackmax,
			LocalDateTime dataTime) {
		super();
		this.id = id;
		this.idsensor = idsensor;
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
	
	@JsonProperty
	public Integer getIdsensor() {return idsensor;}
	@JsonProperty
	public void setIdsensor(Integer idsensor) {this.idsensor = idsensor;}
	
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
}
