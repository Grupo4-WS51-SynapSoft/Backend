package pe.edu.upc.center.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SafeChildPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafeChildPlatformApplication.class, args);
	}

}
