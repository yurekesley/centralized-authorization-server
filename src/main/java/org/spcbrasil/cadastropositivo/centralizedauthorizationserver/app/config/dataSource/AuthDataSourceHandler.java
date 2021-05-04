package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.config.dataSource;

import javax.sql.DataSource;

/**
 * @author yure.placido
 *
 */
public interface AuthDataSourceHandler {
	DataSource dataSource();
}
