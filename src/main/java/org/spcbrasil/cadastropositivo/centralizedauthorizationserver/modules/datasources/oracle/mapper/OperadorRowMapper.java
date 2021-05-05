package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.entity.Operador;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author yure.placido
 *
 */
public class OperadorRowMapper implements RowMapper<Operador> {

	private final List<? extends GrantedAuthority> roles;

	public OperadorRowMapper(List<? extends GrantedAuthority> roles) {
		this.roles = roles;
	}

	@Override
	public Operador mapRow(ResultSet rs, int rowNum) throws SQLException {

		String senha = rs.getString("senha");
		String codigo = rs.getString("codigo");
		String idPerfil = rs.getString("idPerfil");
		String status = rs.getString("status");
		boolean enabled = "A".equals(status);
		boolean accountNonExpired = !"I".equals(status);
		boolean accountNonLocked = !"B".equals(status);
		boolean credentialsNonExpired = true;

		Operador operador = new Operador(codigo, senha, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, roles);
		operador.setId(rs.getString("id"));
		operador.setCodigo(codigo);
		operador.setNome(rs.getString("nome"));
		operador.setIdAssociado(rs.getString("idAssociado"));
		operador.setCodigoAssociado(rs.getString("codigoAssociado"));
		operador.setNomeAssociado(rs.getString("nomeAssociado"));
		operador.setIdEntidade(rs.getString("idEntidade"));
		operador.setCodigoEntidade(rs.getString("codigoEntidade"));
		operador.setNomeEntidade(rs.getString("nomeEntidade"));
		operador.setIdProcessado(rs.getString("idProcessador"));
		operador.setTipo(rs.getString("tipo"));
		operador.setIdPerfil(idPerfil);

		return operador;
	}

}
