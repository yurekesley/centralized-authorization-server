package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.config;

import javax.sql.DataSource;

/**
 * @author yure.placido
 *
 */
public interface AuthDriverHandler {
	DataSource dataSource();
}
