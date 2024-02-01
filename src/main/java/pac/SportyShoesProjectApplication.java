package pac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@ComponentScan(basePackages = "pac.controller")
@SpringBootApplication(scanBasePackages = {"pac.configurations","pac.controller","pac.DTO","pac.globalpac.model","pac.repository","pac.service"})

public class SportyShoesProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyShoesProjectApplication.class, args);
	}

}
