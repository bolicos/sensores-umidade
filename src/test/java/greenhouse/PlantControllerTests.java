package greenhouse;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import greenhouse.controllers.PlantController;
import greenhouse.models.Read;
import greenhouse.models.Sensor;
import greenhouse.models.Type;
import greenhouse.repositories.PlantRepository;


@RunWith(SpringRunner.class)
@WebMvcTest(PlantController.class)
@WithMockUser(roles = "PLANT_ADMIN")
public class PlantControllerTests {
	
	private static final Integer TEST_PLANT_ID = 1;
	private static final Integer TEST_TYPE_ID = 1;
	private static final Integer TEST_SENSOR_ID = 1;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PlantRepository plants;
	
	private Read read;
	private Type type;
	private Sensor sensor;
	
	@Before
	public void setup() {
		this.read = new Read();
		this.read.setId(TEST_PLANT_ID);
		//this.plant.setIdSensor(TEST_SENSOR_ID);
		//this.plant.setType(TEST_TYPE_ID);
		this.read.setHumidity(70);
	}
	@Test
	public void welcome() throws Exception {
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("welcome"));
		
	}
    
}
