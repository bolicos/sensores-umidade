package greenhouse.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class Type extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	public Type() {super();}

	@Column(name = "name")
	private String name;
	@Column(name = "trackmin")
    private Integer trackmin;
	@Column(name = "trackmax")
    private Integer trackmax;
	
	public Type(String name, Integer trackmin,Integer trackmax) {
		super();
		this.name = name;
		this.trackmin = trackmin;
		this.trackmax = trackmax;
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public Integer getTrackmin() {return trackmin;}
	public void setTrackmin(Integer trackmin) {this.trackmin = trackmin;}

	public Integer getTrackmax() {return trackmax;}
	public void setTrackmax(Integer trackmax) {this.trackmax = trackmax;}
	
	@Override
	public String toString() {
		return "Type [name=" + name + ", trackmin=" + trackmin + ", trackmax=" + trackmax + ", getId()=" + getId()
				+ ", isNew()=" + isNew() + "]";
	}
}
