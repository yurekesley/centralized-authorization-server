package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * @author yure.placido
 */
@Configuration
public class MBeanConfig {

	@Bean
	public MBeanExporter exporter() {
		final MBeanExporter exporter = new MBeanExporter();
		exporter.setRegistrationPolicy(RegistrationPolicy.IGNORE_EXISTING);
		return exporter;
	}
}
