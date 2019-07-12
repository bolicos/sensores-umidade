package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sensor {

    private String id;
    private String humidity;
    //private Type type;

    public Sensor() {}
    
    @JsonProperty
    public String getId() {return id;}
    @JsonProperty
    public void setId(String id) {this.id = id;}
    @JsonProperty
    public String getHumidity() {return humidity;}
    @JsonProperty
	public void setHumidity(String humidity) {this.humidity = humidity;}

	@Override
	public String toString() {
		return "Sensor [id=" + id + ", humidity=" + humidity + "]";
	}
	
/*    
    public Type getType() {return type;}
    public void setType(Type type) {this.type = type;}

    @Override
    public String toString() {return "Sensor{" + "id='" + id + '\'' + ", type=" + type + '}';}
*/
    
    
}