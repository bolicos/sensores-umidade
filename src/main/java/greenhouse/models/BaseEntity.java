package greenhouse.models;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonProperty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public boolean isNew() {return this.id == null;}
}
