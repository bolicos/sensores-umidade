package greenhouse.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Sensor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@Column(name = "name")
    private String name;
	@Column(name = "humidity")
	private int humidity;
	@Column(name = "status")
    private String status;
	@Column(name = "trackmin")
    private int trackmin = 60;
	@Column(name = "trackmax")
    private int trackmax = 80;
	@Column(name = "dataTime")
	private LocalDateTime dataTime;
	
	public Sensor(Integer id, String name, int humidity, String status, int trackmin, int trackmax,
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
	
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public int getHumidity() {return humidity;}
	public void setHumidity(int humidity) {this.humidity = humidity;}
	
	public String getStatus() {return status;}
	public void setStatus(String status) {this.status = status;}
	
	public int getTrackmin() {return trackmin;}
	public void setTrackmin(int trackmin) {this.trackmin = trackmin;}
	
	public int getTrackmax() {return trackmax;}
	public void setTrackmax(int trackmax) {this.trackmax = trackmax;}
	
	public LocalDateTime getDataTime() {return dataTime;}
	public void setDataTime(LocalDateTime dataTime) {this.dataTime = dataTime;}
	
	@Override
	public String toString() {
		return "Sensor [id=" + id + ", name=" + name + ", humidity=" + humidity + ", status=" + status + ", trackmin="
				+ trackmin + ", trackmax=" + trackmax + ", dataTime=" + dataTime + "]";
	}
}
