package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.prividers;

import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.security.authentications.UsernamePasswordAuthentication;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author yure.placido
 *
 */
@Component
public class JdbcTemplateOracleProvider implements AuthenticationProvider {

	private final PasswordEncoder passwordEncoder;
	private final UserDetailsService userDetailsService;

	public JdbcTemplateOracleProvider(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
		this.passwordEncoder = passwordEncoder;
		this.userDetailsService = userDetailsService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();

		UserDetails user = userDetailsService.loadUserByUsername(username);
		if (passwordEncoder.matches(password, user.getPassword())) {
			return new UsernamePasswordAuthentication(username, password, user.getAuthorities());
		}
		throw new BadCredentialsException("Bad Credentials!");
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return UsernamePasswordAuthenticationToken.class.equals(clazz);
	}

}
