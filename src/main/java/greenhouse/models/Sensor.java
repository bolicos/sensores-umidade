package greenhouse.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "sensors")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sensor extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	public Sensor() {super();}
	
	@ManyToOne
    @JoinColumn(name = "username")
    private User user;
	
	@ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;
	
	@OneToMany
	@Transient
    private Set<Read> reads;

	@Column(name = "name")
	private String name;
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public User getUser() {return user;}
	public void setUser(User user) {this.user = user;}
	
	public Plant getPlant() {return plant;}
	public void setPlant(Plant plant) {this.plant = plant;}
	
	public Set<Read> getReads() {return reads;}
	public void setReads(Set<Read> reads) {this.reads = reads;}
	
	@Override
	public String toString() {
		return "Sensor [user=" + user + ", plant=" + plant + ", reads=" + reads + ", name=" + name + ", getId()="
				+ getId() + ", isNew()=" + isNew() + "]";
	}
	
}
