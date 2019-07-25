package greenhouse.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "plants")
public class Plant extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	public Plant() {super();}
	
	@Column(name = "type_id")
	private Type type;
	
	@OneToMany
    private Set<Sensor> reads;
	
	public Type getType() {return type;}
	public void setType(Type type) {this.type = type;}

	public Set<Sensor> getReads() {return reads;}
	public void setReads(Set<Sensor> reads) {this.reads = reads;}

	@Override
	public String toString() {
		return "Plant [type=" + type + ", reads=" + reads + ", getId()=" + getId() + ", isNew()=" + isNew() + "]";
	}

}
