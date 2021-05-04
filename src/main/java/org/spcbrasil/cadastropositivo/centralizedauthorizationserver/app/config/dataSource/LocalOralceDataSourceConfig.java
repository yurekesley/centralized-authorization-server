package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.config.dataSource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

/**
 * @author yure.placido
 *
 */
@Configuration
@Profile("local")
@PropertySource("classpath:jdbc-local.properties")
public class LocalOralceDataSourceConfig {

	@Autowired
	private Environment env;

	@Bean("oracle")
	public DataSource oracle() {
		SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		dataSource.setSuppressClose(true);
		return dataSource;
	}

}
