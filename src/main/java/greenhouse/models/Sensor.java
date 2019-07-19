package greenhouse.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sensors")
public class Sensor extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	public Sensor() {
		super();
	}
	
	@Override
	public String toString() {
		return "Sensor [getId()=" + getId() + ", isNew()=" + isNew() + "]";
	}
}
