package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.security.authentications;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author yure.placido
 *
 */
public class UsernamePasswordAuthentication extends UsernamePasswordAuthenticationToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsernamePasswordAuthentication(Object principal, Object credentials) {
		super(principal, credentials);
	}

	public UsernamePasswordAuthentication(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
	}
}
