package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.h2;

import javax.sql.DataSource;

import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.annotation.DatabaseType;
import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.config.dataSource.AuthDataSourceHandler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

/**
 * @author yure.placido
 *
 */
@Configuration
@DatabaseType("h2")
public class H2AuthDriverHandler implements AuthDataSourceHandler {

	private final DataSource dataSource;

	public H2AuthDriverHandler(@Qualifier("h2") DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	public DataSourceInitializer dataSourceInitializer(@Qualifier("h2") DataSource dataSource) {
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource);

		dataSourceInitializer.setDatabasePopulator(databasePopulator());
		dataSourceInitializer.setEnabled(Boolean.TRUE);
		return dataSourceInitializer;
	}

	private ResourceDatabasePopulator databasePopulator() {
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.addScripts(new ClassPathResource("vendor/h2/schema.sql"));
		databasePopulator.addScripts(new ClassPathResource("vendor/h2/data.sql"));
		return databasePopulator;
	}

	@Override
	public DataSource dataSource() {
		return dataSource;
	}

}
