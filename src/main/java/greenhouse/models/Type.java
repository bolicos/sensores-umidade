package greenhouse.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class Type extends BaseEntity{
	
	public Type() {
		super();
	}

	private static final long serialVersionUID = 1L;
	
	@Column(name = "name")
	private String name;
	
	public Type(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	@Override
	public String toString() {
		return "Type [name=" + name + ", getId()=" + getId() + ", isNew()=" + isNew() + "]";
	}
}
