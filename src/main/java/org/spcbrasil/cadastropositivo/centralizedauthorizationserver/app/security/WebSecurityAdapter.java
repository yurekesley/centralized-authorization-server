package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * @author yure.placido
 */
@EnableWebSecurity
public class WebSecurityAdapter extends WebSecurityConfigurerAdapter {

	private final List<AuthenticationProvider> providers;

	public WebSecurityAdapter(@Autowired(required = false) List<AuthenticationProvider> prividers) {
		this.providers = prividers;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		if (providers != null)
			providers.forEach(provide -> {
				auth.authenticationProvider(provide);
			});
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.headers().frameOptions().disable();
		http.csrf().disable().authorizeRequests().antMatchers("/login").permitAll().antMatchers("/h2-console/*")
				.permitAll().antMatchers("/tokens/**").permitAll().antMatchers("/oauth/authorize").authenticated()
				.anyRequest().authenticated();
		// @formatter:on
	}

}
