package greenhouse.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class Type extends BaseEntity{
	public Type(String name) {
		super();
		Name = name;
	}

	private static final long serialVersionUID = 1L;
	private String Name;
	
	
	public String getName() {return Name;}
	public void setName(String name) {Name = name;}
	
	@Override
	public String toString() {
		return "Type [Name=" + Name + ", getId()=" + getId() + ", isNew()=" + isNew() + "]";
	}
}
