package greenhouse.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "plants")
public class Plant extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	public Plant() {super();}
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id")
	private Type type;
	
	@OneToMany(fetch = FetchType.EAGER)
	@Transient
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
