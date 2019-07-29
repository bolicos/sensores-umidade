package greenhouse.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "roles" ,uniqueConstraints = @UniqueConstraint(columnNames = {"id", "role"}))
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@ManyToMany
    @JoinColumn(name = "username")
	private Set<User> users;
	
	@Column( name = "role")
    private String name;
	
	@ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {return users;}
    public void setUsers(Set<User> users) {this.users = users;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    
}
