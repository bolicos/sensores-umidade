package greenhouse.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

public class Customer extends BaseEntity {
	private static final long serialVersionUID = 1L;

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
    
    @OneToMany
	private Collection<Sensor> sensors;
    
    public String getFirstName() {return this.firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return this.lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
	
    public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public Boolean getEnabled() {return enabled;}
    public void setEnabled(Boolean enabled) {this.enabled = enabled;}

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
          //sensor.setUser(this);
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


}
