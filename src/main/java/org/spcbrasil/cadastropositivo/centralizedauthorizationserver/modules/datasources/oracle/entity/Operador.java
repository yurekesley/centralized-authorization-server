package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @author yure.placido
 *
 */
public class Operador extends User {

	private static final long serialVersionUID = 1L;

	private String id;
	private String codigo;
	private String nome;
	private String idAssociado;
	private String codigoAssociado;
	private String nomeAssociado;
	private String idEntidade;
	private String codigoEntidade;
	private String nomeEntidade;
	private String idProcessado;
	private String tipo;
	private String idPerfil;
	private String secret = "2VXLQD2FVDNOP7T5";

	public Operador(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdAssociado() {
		return idAssociado;
	}

	public void setIdAssociado(String idAssociado) {
		this.idAssociado = idAssociado;
	}

	public String getCodigoAssociado() {
		return codigoAssociado;
	}

	public void setCodigoAssociado(String codigoAssociado) {
		this.codigoAssociado = codigoAssociado;
	}

	public String getNomeAssociado() {
		return nomeAssociado;
	}

	public void setNomeAssociado(String nomeAssociado) {
		this.nomeAssociado = nomeAssociado;
	}

	public String getIdEntidade() {
		return idEntidade;
	}

	public void setIdEntidade(String idEntidade) {
		this.idEntidade = idEntidade;
	}

	public String getCodigoEntidade() {
		return codigoEntidade;
	}

	public void setCodigoEntidade(String codigoEntidade) {
		this.codigoEntidade = codigoEntidade;
	}

	public String getNomeEntidade() {
		return nomeEntidade;
	}

	public void setNomeEntidade(String nomeEntidade) {
		this.nomeEntidade = nomeEntidade;
	}

	public String getIdProcessado() {
		return idProcessado;
	}

	public void setIdProcessado(String idProcessado) {
		this.idProcessado = idProcessado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isOperadorAssociado() {
		return "associado".equals(getTipo());
	}

	public boolean isOperadorEntidadeOuBoe() {
		return "entidade".equals(getTipo());
	}

	public boolean isOperadorProcessador() {
		return "processador".equals(getTipo());
	}

	public String getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(String idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
}
