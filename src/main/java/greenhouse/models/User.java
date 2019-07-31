package greenhouse.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements UserDetails, Serializable{
	private static final long serialVersionUID = 1L;

	public User() {super();} //Constructor Default
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "username", unique = true)
    @NotEmpty
    private String username;
	
	@Column
    @NotEmpty
    private String password;
	
	@Transient
	private String passwordConfirm;
	
	@Column(name = "first_name")
    @NotEmpty
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty
    private String lastName; 
	
	@Column
    @NotEmpty
    private String email;
    
    @Column
    private Boolean enabled;
    
    @ManyToMany
	@JoinTable( 
	        name = "fk_users_roles", 
	        joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "username"), 
	        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")) 
    private List<Role> roles;
    
	@OneToMany
	private Collection<Sensor> sensors;
	
	@Override
	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}
	
	@Override
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	
    public String getPasswordConfirm() {return this.passwordConfirm;}
    public void setPasswordConfirm(String passwordConfirm) {this.passwordConfirm = passwordConfirm;}
	
	public String getFirstName() {return this.firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return this.lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
	
    public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public Boolean getEnabled() {return enabled;}
    public void setEnabled(Boolean enabled) {this.enabled = enabled;}
	
 //-------------------------ROLES OF USER-------------------------
    public List<Role> getRoles() {return roles;}
    public void setRoles(List<Role> roles) {this.roles = roles;}
    
//    public void addRole(String roleName) {
//        if(this.roles == null) {this.roles = new HashSet<Role>();}
//        Role role = new Role();
//        role.setName(roleName);
//        this.roles.add(role);
//    }
    
  //------------------------------END------------------------------   
  
  //-------------------------SENSORS OF USER-------------------------
	protected Collection<Sensor> getSensorsInternal() {//INTERNAL
        if (this.sensors == null) {this.sensors = new HashSet<Sensor>();}
        return this.sensors;
    }
	protected void setSensorsInternal(Collection<Sensor> sensors) {this.sensors = sensors;}//INTERNAL
	
	public List<Sensor> getSensors() {
        List<Sensor> sortedSensors = new ArrayList<>(getSensorsInternal());
        PropertyComparator.sort(sortedSensors,
                new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedSensors);
    }
	
	public void addSensor(Sensor sensor) {
        if (sensor.isNew()) {getSensorsInternal().add(sensor);}
        sensor.setUser(this);
    }
	
	public Sensor getSensor(String name) {return getSensor(name, false);}
	
	public Sensor getSensor(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Sensor sensor : getSensorsInternal()) {
            if (!ignoreNew || !sensor.isNew()) {
                String compName = sensor.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {return sensor;}
            }
        }
        return null;
    }
//------------------------------END------------------------------
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", passwordConfirm=" + passwordConfirm
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", enabled=" + enabled
				+ ", roles=" + roles + ", sensors=" + sensors + "]";
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {return (Collection<? extends GrantedAuthority>) this.roles;}
	@Override
	public boolean isAccountNonExpired() {return true;}
	@Override
	public boolean isAccountNonLocked() {return true;}
	@Override
	public boolean isCredentialsNonExpired() {return true;}
	@Override
	public boolean isEnabled() {return true;}
	
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((username == null) ? 0 : username.hashCode());
//		return result;
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		User other = (User) obj;
//		if (username == null) {
//			if (other.username != null)
//				return false;
//		} else if (!username.equals(other.username))
//			return false;
//		return true;
//	}
	
}
