package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.service;

import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.entity.Operador;
import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.mapper.OperadorRowMapper;
import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.mapper.RoleRowMapper;
import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.util.UsuarioPorCodigoOperadorQueryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yure.placido
 *
 */
@Component
@Transactional
public class OracleCustomUserDetailsService implements UserDetailsService {

	static final String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";
	static final String ROLE_USER = "USER";
	static final String ROLE_READ_PREFIX = "ROLE_READ_";
	static final String ROLE_CREATE_PREFIX = "ROLE_CREATE_";
	static final String ROLE_UPDATE_PREFIX = "ROLE_UPDATE_";
	static final String ROLE_REMOVE_PREFIX = "ROLE_REMOVE_";

	private final JdbcTemplate jdbcTemplate;

	public OracleCustomUserDetailsService(@Qualifier("oracle") DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<GrantedAuthority> roles = getUserRoles(username);
		Operador operador = getOperador(username, roles);
		return operador;
	}

	private Operador getOperador(String username, List<GrantedAuthority> roles) {
		return jdbcTemplate.queryForObject(new UsuarioPorCodigoOperadorQueryBuilder().build(),
				new OperadorRowMapper(roles), new Object[] { username });
	}

	private List<GrantedAuthority> getUserRoles(String username) {

		List<GrantedAuthority> roles = jdbcTemplate.query(new UsuarioPorCodigoOperadorQueryBuilder().build(),
				new RoleRowMapper(), new Object[] { username });

		List<GrantedAuthority> rolesPadrao = Arrays.asList(new SimpleGrantedAuthority(ROLE_ANONYMOUS),
				new SimpleGrantedAuthority(ROLE_USER));

		roles.addAll(rolesPadrao);

		return roles;
	}
}
