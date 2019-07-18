package greenhouse;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import greenhouse.controllers.PlantController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlantControllerTests {
	
	@Autowired
	private PlantController plantController;
	
    @Test
    public void contexLoads() throws Exception {
        assertThat(plantController).isNotNull();
    }
}
