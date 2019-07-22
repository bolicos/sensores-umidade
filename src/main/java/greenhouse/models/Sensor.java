package greenhouse.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sensors")
public class Sensor extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	public Sensor() {
		super();
	}

	@Column(name = "name")
	private String name;
	
	public Sensor(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	@Override
	public String toString() {
		return "Sensor [name=" + name + ", getId()=" + getId() + ", isNew()=" + isNew() + "]";
	}
}
