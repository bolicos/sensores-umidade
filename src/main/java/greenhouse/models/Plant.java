package greenhouse.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Plant extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	
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
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getStatus() {return status;}
	public void setStatus(String status) {this.status = status;}
	
	public Integer getTrackmin() {return trackmin;}
	public void setTrackmin(Integer trackmin) {this.trackmin = trackmin;}
	
	public Integer getTrackmax() {return trackmax;}
	public void setTrackmax(Integer trackmax) {this.trackmax = trackmax;}
	
	public LocalDateTime getDataTime() {return dataTime;}
	public void setDataTime(LocalDateTime dataTime) {this.dataTime = dataTime;}
	

	
	
		
}
