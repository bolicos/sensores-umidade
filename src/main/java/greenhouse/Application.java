package greenhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {

	public static void main(String args[]) {
		SpringApplication.run(Application.class);
		System.out.print(new BCryptPasswordEncoder().encode("senh@joao"));
	}
	
	
}
