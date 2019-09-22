package greenhouse.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity implements GrantedAuthority {
	private static final long serialVersionUID = 1L;

	
	private String name;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String getAuthority() {
		return getName();
	}
	
	
}
   