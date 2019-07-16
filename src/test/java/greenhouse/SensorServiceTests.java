package greenhouse;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SensorServiceTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void getDataSensor1Test() throws Exception {
        assertThat(this.restTemplate.getForObject("http://fundatec.dev.aioria.com.br/api/v1/humidity",String.class))
        	.isNotNull();
    }
}