package greenhouse.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public class Person extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "first_name")
    @NotBlank(message = "Campo nome obrigatorio.")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Campo sobrenome obrigatorio.")
    private String lastName;

    public String getFirstName() {return this.firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return this.lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
	
}
