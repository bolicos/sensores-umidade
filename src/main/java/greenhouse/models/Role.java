package greenhouse.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "roles" ,uniqueConstraints = @UniqueConstraint(columnNames = {"id", "role"}))
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role extends BaseEntity implements GrantedAuthority {
	private static final long serialVersionUID = 1L;

	@OneToMany
	private Collection<User> users;
	
	@Column( name = "role")
    private String name;
	
	
    public Collection<User> getUsers() {return users;}
    public void setUsers(Collection<User> users) {this.users = users;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    
	@Override
	public String getAuthority() {return this.getName();}
    
}
