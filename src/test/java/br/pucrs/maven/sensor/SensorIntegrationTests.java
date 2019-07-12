package br.pucrs.maven.sensor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.pucrs.maven.sensor.model.Sensor;
import br.pucrs.maven.sensor.sensor.SensorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SensorIntegrationTests {

	private static final int TEST_SENSOR_ID = 1;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SensorRepository sensors;

	private Sensor sensor;

	@Before
	public void setup() {
		sensor = new Sensor();
		sensor.setId(TEST_SENSOR_ID);
		sensor.setName("Sensor 1");
		sensor.setPlant("Strawberry");
	}
    
    @Test
    public void testFindAll() throws Exception {
    	sensors.findAll();
    }
}
