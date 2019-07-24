package greenhouse.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

@Entity
@Table(name = "users")
public class User extends Person{
	private static final long serialVersionUID = 1L;
	
	@Column
    @NotEmpty
    private String email;

	@OneToMany
	private Set<Type> plants;
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	protected Set<Type> getPlantsInternal() {
        if (this.plants == null) {
            this.plants = new HashSet<>();
        }
        return this.plants;
    }
	
	protected void setPlantsInternal(Set<Type> plants) {
		this.plants = plants;
	}
	
	public List<Type> getPlants() {
        List<Type> sortedPlants = new ArrayList<>(getPlantsInternal());
        PropertyComparator.sort(sortedPlants,
                new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedPlants);
    }
	
	public void addPlant(Type type) {
        if (type.isNew()) {
        	getPlantsInternal().add(type);
        }
        type.setUser(this);
    }
	
	public Type getPlant(String name) {
        return getPlant(name, false);
    }
	
	public Type getPlant(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Type type : getPlantsInternal()) {
            if (!ignoreNew || !type.isNew()) {
                String compName = type.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return type;
                }
            }
        }
        return null;
    }
	
}
