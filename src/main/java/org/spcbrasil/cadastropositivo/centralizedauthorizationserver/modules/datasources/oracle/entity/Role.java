package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author yure.placido
 *
 */
public class Role implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Role(String role) {
		this.role = role;
	}

	private String subSistema;
	private Integer idPerfil;
	private String role;
	private String tipoPermisao;

	public String getSubSistema() {
		return subSistema;
	}

	public void setSubSistema(String subSistema) {
		this.subSistema = subSistema;
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTipoPermisao() {
		return tipoPermisao;
	}

	public void setTipoPermisao(String tipoPermisao) {
		this.tipoPermisao = tipoPermisao;
	}

	@Override
	public String getAuthority() {
		return role;
	}

}
