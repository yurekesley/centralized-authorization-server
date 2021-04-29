package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app;

import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.annotation.EnableH2Module;
import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.annotation.EnableOracleModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yure.placido
 */

@EnableH2Module
@EnableOracleModule
@SpringBootApplication
public class CentralizedAuthorizationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralizedAuthorizationServerApplication.class, args);
	}

}
