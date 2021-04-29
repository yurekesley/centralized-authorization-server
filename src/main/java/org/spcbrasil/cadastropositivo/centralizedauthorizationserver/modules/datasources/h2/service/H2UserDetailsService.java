package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.h2.service;

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
public class H2UserDetailsService implements UserDetailsService {

	private final DataSource dataSource;

	public H2UserDetailsService(@Qualifier("h2") DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JdbcDaoImpl jdbcDaoImpl = new JdbcDaoImpl();
		jdbcDaoImpl.setDataSource(dataSource);
		return jdbcDaoImpl.loadUserByUsername(username);
	}

}
