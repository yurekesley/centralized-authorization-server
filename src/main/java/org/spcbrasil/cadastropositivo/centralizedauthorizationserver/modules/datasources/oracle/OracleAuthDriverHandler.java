package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle;

import javax.sql.DataSource;

import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.annotation.DatabaseType;
import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.config.dataSource.AuthDataSourceHandler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

/**
 * @author yure.placido
 *
 */
@Configuration
@DatabaseType("oracle")
public class OracleAuthDriverHandler implements AuthDataSourceHandler {

	private final DataSource dataSource;

	public OracleAuthDriverHandler(@Qualifier("oracle") DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public DataSource dataSource() {
		return dataSource;
	}

}
