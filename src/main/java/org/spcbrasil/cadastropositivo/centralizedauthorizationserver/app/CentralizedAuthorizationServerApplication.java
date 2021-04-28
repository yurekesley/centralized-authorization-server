package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app;

import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.annotation.EnableOracleModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author yure.placido
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableOracleModule
public class CentralizedAuthorizationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralizedAuthorizationServerApplication.class, args);
	}

}
