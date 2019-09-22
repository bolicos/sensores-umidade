package greenhouse.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class User implements UserDetails, Serializable{
	private static final long serialVersionUID = 1L;

	public User() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Campo nome obrigatorio.")
	@Column(name = "username", unique = true)
    private String username;
	
    @NotBlank(message = "Campo senha obrigatorio.")
    @Column(name = "password", nullable = false)
    private String password;
	
	@Transient
	private String passwordConfirm;
	
	@Column(name = "enabled", nullable = false)
    private Boolean enabled;
    
    @ManyToMany
    private Collection<Role> roles;
	
	@Override
	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}
	
	@Override
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	
    public String getPasswordConfirm() {return this.passwordConfirm;}
    public void setPasswordConfirm(String passwordConfirm) {this.passwordConfirm = passwordConfirm;}
	
    public Collection<Role> getRoles() {return roles;}
    public void setRoles(Collection<Role> roles) {this.roles = roles;}
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {return getRoles();}
	@Override
	public boolean isAccountNonExpired() {return true;}
	@Override
	public boolean isAccountNonLocked() {return true;}
	@Override
	public boolean isCredentialsNonExpired() {return true;}
	@Override
	public boolean isEnabled() {return enabled;}
	
  public void addRole(String roleName) {
	  if(this.roles == null) {this.roles = new ArrayList<Role>();}
	  Role role = new Role();
	  role.setName(roleName);
	  this.roles.add(role); 
	}
	
}
