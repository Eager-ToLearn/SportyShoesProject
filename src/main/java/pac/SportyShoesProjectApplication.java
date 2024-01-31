package pac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;


//@ComponentScan(basePackages = "pac.controller")
@SpringBootApplication(scanBasePackages = {"pac.configurations","pac.controller","pac.DTO","pac.globalpac.model","pac.repository","pac.service"})

public class SportyShoesProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyShoesProjectApplication.class, args);
	}

}
