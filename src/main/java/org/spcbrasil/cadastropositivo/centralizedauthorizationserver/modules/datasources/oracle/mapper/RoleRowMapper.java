package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.entity.Role;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author yure.placido
 *
 */
public class RoleRowMapper implements RowMapper<GrantedAuthority>{

	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		Role role = new Role();
		
		return role;
	}

}
