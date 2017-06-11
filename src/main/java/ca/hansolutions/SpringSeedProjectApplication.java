package ca.hansolutions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringSeedProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSeedProjectApplication.class, args);
	}
}
