package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.entity.Operador;
import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.mapper.OperadorRowMapper;
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
		String sql = new UsuarioPorCodigoOperadorQueryBuilder().build();
		List<GrantedAuthority> roles = getUserRoles(username);
		Operador operador = jdbcTemplate.queryForObject(sql, new OperadorRowMapper(roles), new Object[] { username });
		return operador;

	}

	// todo, mudar essa merda que está errada.

	private static String LOAD_PERFIL_BY_ID = "select f.NOM_ROLE roleSufix," + "  a.idc_create idcCreate,"
			+ "  a.idc_update idcUpdate," + "  a.idc_remove idcRemove" + " from spcjava.perfil p,"
			+ "  spcjava.permissao_acesso a," + "  spcjava.funcionalidade f," + "  spcjava.subsistema s"
			+ " where p.id = a.id_perfil" + "  and a.id_funcionalidade = f.id" + "  and f.id_subsistema = s.id"
			+ "  and f.idc_ativo = 'S'" + "  and s.idc_rdr = 'S'" + "  and f.TIP_SISTEMA = 'J'" + "  and p.id = ?";

	//@SuppressWarnings("deprecation")
	private List<GrantedAuthority> getUserRoles(String username) {
		List<GrantedAuthority> grants = new ArrayList<>();
		grants.add(new SimpleGrantedAuthority(ROLE_ANONYMOUS));
		grants.add(new SimpleGrantedAuthority(ROLE_USER));
		
		return grants;
		
		/*

		this.jdbcTemplate.query(LOAD_PERFIL_BY_ID, new Object[] { Long.parseLong(idPerfil) }, (rs, rownum) -> {

			String roleSufix = rs.getString("roleSufix");
			grants.add(new SimpleGrantedAuthority(ROLE_READ_PREFIX + roleSufix));
			if ("S".equals(rs.getString("idcCreate"))) {
				grants.add(new SimpleGrantedAuthority(ROLE_CREATE_PREFIX + roleSufix));
			}
			if ("S".equals(rs.getString("idcUpdate"))) {
				grants.add(new SimpleGrantedAuthority(ROLE_UPDATE_PREFIX + roleSufix));
			}
			if ("S".equals(rs.getString("idcRemove"))) {
				grants.add(new SimpleGrantedAuthority(ROLE_REMOVE_PREFIX + roleSufix));
			}

			return null;

		});

		return grants;
		*/
	}
}
