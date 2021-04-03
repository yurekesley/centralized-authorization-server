package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author yure.placido
 *
 */
@Configuration
public class WebSecurityConfiguration {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return DefaultPasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
