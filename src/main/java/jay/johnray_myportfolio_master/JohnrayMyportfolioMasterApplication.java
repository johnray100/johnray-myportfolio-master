package jay.johnray_myportfolio_master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"jay.johnray_myportfolio_master", "ph.gov.bsp.bcvs"})
@EntityScan(basePackages = {"ph.gov.bsp.bcvs.entity"})
@EnableJpaRepositories(basePackages = {"ph.gov.bsp.bcvs.dao"})
public class JohnrayMyportfolioMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(JohnrayMyportfolioMasterApplication.class, args);
	}

}
