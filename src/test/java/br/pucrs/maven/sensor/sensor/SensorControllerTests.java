package br.pucrs.maven.sensor.sensor;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.pucrs.maven.sensor.model.Sensor;

@RunWith(SpringRunner.class)
@WebMvcTest(SensorController.class)
@WithMockUser(roles = "SENSOR_ADMIN")
public class SensorControllerTests {

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
	public void testProcessFindFormByLastName() throws Exception {
		BDDMockito.given(this.sensors.findAll()).willReturn(Lists.newArrayList(sensor));
		mockMvc.perform(MockMvcRequestBuilders.get("/sensors")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.model().attributeExists("sensors"));
	}

	@Test
	public void testShowSensor() throws Exception {
		BDDMockito.given(this.sensors.findById(TEST_SENSOR_ID)).willReturn(sensor);
		mockMvc.perform(MockMvcRequestBuilders.get("/sensors/{sensorId}", TEST_SENSOR_ID))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.model().attribute("sensor",
						hasProperty("name", is("Sensor 1"))))
				.andExpect(MockMvcResultMatchers.view().name("sensors/sensorDetails"));
	}

}
