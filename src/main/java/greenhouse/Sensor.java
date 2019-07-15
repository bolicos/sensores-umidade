package greenhouse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sensor {

    private String id;
    private int humidity;
    //private Type type;
    private String status;


	public String getStatus() {return status;}
	public void setStatus(String status) {this.status = status;}

	public Sensor() {}
    
    @JsonProperty
    public String getId() {return id;}
    @JsonProperty
    public void setId(String id) {this.id = id;}
    @JsonProperty
    public int getHumidity() {return humidity;}
    @JsonProperty
	public void setHumidity(int humidity) {this.humidity = humidity;}

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