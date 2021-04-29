package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.h2;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yure.placido
 *
 */

@Configuration
public class H2DataSourceConfig {

	@Bean("h2")
	public DataSource h2() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.h2.Driver");
		dataSourceBuilder.url("jdbc:h2:mem:testdb;MODE=ORACLE");
		dataSourceBuilder.username("SA");
		dataSourceBuilder.password("");
		return dataSourceBuilder.build();
	}
}
