package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.security.providers;

import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.security.authentications.UsernamePasswordAuthentication;
import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.security.service.JdbcCustomUserDetailsService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author yure.placido
 *
 */
@Component
public class JdbcAuthenticationProvider implements AuthenticationProvider {

	private final JdbcCustomUserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;

	public JdbcAuthenticationProvider(JdbcCustomUserDetailsService userDetailsService,
			PasswordEncoder passwordEncoder) {
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();

		UserDetails user = userDetailsService.loadUserByUsername(username);
		if (passwordEncoder.matches(password, user.getPassword())) {
			return new UsernamePasswordAuthentication(username, password, user.getAuthorities());
		}

		throw new BadCredentialsException(":(");
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return UsernamePasswordAuthenticationToken.class.equals(clazz);
	}

}
