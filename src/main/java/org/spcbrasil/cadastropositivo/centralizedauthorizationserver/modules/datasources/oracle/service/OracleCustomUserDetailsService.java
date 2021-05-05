package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.entity.Operador;
import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.entity.Role;
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

	// TODO VERIFICAR COMO RESOLVER A QUESTÃO DA VISUALIZAÇÃO
	static final String ROLE_READ_PREFIX = "ROLE_READ_";

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

		this.adicionarRolesPadrao(roles);

		return roles;
	}

	private void adicionarRolesPadrao(List<GrantedAuthority> roles) {
		List<GrantedAuthority> rolesPadrao = Arrays.asList(new Role(ROLE_ANONYMOUS),
				new Role(ROLE_USER));
		roles.addAll(rolesPadrao);
		roles.removeAll(Collections.singletonList(null));
	}
}
