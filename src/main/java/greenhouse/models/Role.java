package greenhouse.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "roles" ,uniqueConstraints = @UniqueConstraint(columnNames = {"id", "role"}))
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role extends BaseEntity implements GrantedAuthority {
	private static final long serialVersionUID = 1L;

	@Column( name = "role")
    private String name;
	
	@ManyToMany(mappedBy = "roles")
	private List<User> users;
	
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    
    public List<User> getUsers() {return users;}
    public void setUsers(List<User> users) {this.users = users;}
    
	@Override
	public String getAuthority() {return this.name;}
    
}
