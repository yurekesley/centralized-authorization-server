package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.h2;

import javax.sql.DataSource;

import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.annotation.DatabaseType;
import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.config.AuthDriverHandler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

/**
 * @author yure.placido
 *
 */
@Configuration
@DatabaseType("h2")
public class H2AuthDriverHandler implements AuthDriverHandler {

	private final DataSource dataSource;

	public H2AuthDriverHandler(@Qualifier("h2") DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public DataSource dataSource() {
		return dataSource;
	}

}
