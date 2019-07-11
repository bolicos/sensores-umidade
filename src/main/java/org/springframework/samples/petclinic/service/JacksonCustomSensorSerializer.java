package org.springframework.samples.petclinic.service;

import java.io.IOException;

import org.springframework.samples.petclinic.sensor.Sensor;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class JacksonCustomSensorSerializer extends StdSerializer<Sensor>  {
	
	
	private static final long serialVersionUID = 1L;
	
	public JacksonCustomSensorSerializer() {this(null);}
	public JacksonCustomSensorSerializer(Class<Sensor> s) {super(s);}
	
	@Override
	public void serialize(Sensor sensor, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		if (sensor.getId() == null) {gen.writeNullField("id");}
		else {gen.writeNumberField("id", sensor.getId());}
		
		gen.writeStringField("name", sensor.getName());
		gen.writeStringField("plant", sensor.getPlant());
		gen.writeStringField("track", sensor.getTrack());
		gen.writeNumberField("humidity", sensor.getHumidity());
		
	}
	
	
	
}
