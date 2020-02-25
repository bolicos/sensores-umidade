package greenhouse.models;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class Customer extends Person {
	private static final long serialVersionUID = 1L;

	@Column(name = "email", nullable = false)
    @NotBlank(message = "Campo email obrigatorio.")
    private String email;
    
    @Column
    private Boolean enabled;

    public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public Boolean getEnabled() {return enabled;}
    public void setEnabled(Boolean enabled) {this.enabled = enabled;}

}
