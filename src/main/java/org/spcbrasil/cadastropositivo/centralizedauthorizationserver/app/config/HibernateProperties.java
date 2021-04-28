package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author yure.placido
 */
@Configuration
@ConfigurationProperties(prefix = "hibernate")
public class HibernateProperties {

	private HBM2DDL hbm2ddl;
	private Boolean showSql;

	public HBM2DDL getHbm2ddl() {
		return hbm2ddl;
	}

	public String getAuto() {
		return hbm2ddl.getAuto();
	}

	public void setHbm2ddl(HBM2DDL hbm2ddl) {
		this.hbm2ddl = hbm2ddl;
	}

	public Boolean getShowSql() {
		return showSql;
	}

	public void setShowSql(Boolean showSal) {
		this.showSql = showSal;
	}

}

class HBM2DDL {

	private String auto;

	public String getAuto() {
		return auto;
	}

	public void setAuto(String auto) {
		this.auto = auto;
	}
}
