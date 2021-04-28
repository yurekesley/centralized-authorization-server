package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.security.service;

import javax.sql.DataSource;

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
public class JdbcCustomUserDetailsService implements UserDetailsService {

	private final DataSource dataSource;

	public JdbcCustomUserDetailsService(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JdbcDaoImpl jdbcDaoImpl = new JdbcDaoImpl();
		jdbcDaoImpl.setDataSource(dataSource);
		return jdbcDaoImpl.loadUserByUsername(username);
	}

}
