package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yure.placido
 *
 */
@Component
@Transactional
public class OracleCustomUserDetailsService implements UserDetailsService {

	private final DataSource dataSource;

	public OracleCustomUserDetailsService(@Qualifier("oracle") DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JdbcDaoImpl jdbcDaoImpl = new JdbcDaoImpl();
		jdbcDaoImpl.setDataSource(dataSource);
		return jdbcDaoImpl.loadUserByUsername(username);
	}

}
