package greenhouse.models;

import javax.persistence.Entity;

@Entity
public class Type extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private String Name;
	
	
	public String getName() {return Name;}
	public void setName(String name) {Name = name;}
	
}
