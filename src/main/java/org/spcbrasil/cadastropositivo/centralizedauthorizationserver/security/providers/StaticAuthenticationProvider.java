package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.security.providers;

import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.security.authentications.UsernamePasswordAuthentication;
import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.security.service.StaticCustomUserDetailsService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author yure.placido
 *
 */
@Component
@SuppressWarnings("deprecation")
public class StaticAuthenticationProvider implements AuthenticationProvider {

	private final StaticCustomUserDetailsService userDetailsService;

	public StaticAuthenticationProvider(StaticCustomUserDetailsService userDetailsService,
			PasswordEncoder passwordEncoder) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();

		PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();

		UserDetails user = userDetailsService.loadUserByUsername(username);

		if ((username.equals(user.getUsername())) && passwordEncoder.matches(password, user.getPassword())) {
			return new UsernamePasswordAuthentication(username, password, user.getAuthorities());
		}

		throw new BadCredentialsException(":(");
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return UsernamePasswordAuthenticationToken.class.equals(aClass);
	}

}
