package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.security;

import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.security.providers.JdbcAuthenticationProvider;
import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.security.providers.StaticAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
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

	private final JdbcAuthenticationProvider jdbcAuthenticationProvider;
	private final StaticAuthenticationProvider staticAuthenticationProvider;

	public WebSecurityAdapter(JdbcAuthenticationProvider jdbcAuthenticationProvider,
			StaticAuthenticationProvider staticAuthenticationProvider) {
		this.jdbcAuthenticationProvider = jdbcAuthenticationProvider;
		this.staticAuthenticationProvider = staticAuthenticationProvider;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(jdbcAuthenticationProvider);
		auth.authenticationProvider(staticAuthenticationProvider);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();

		http.csrf().disable().authorizeRequests().antMatchers("/resources/", "/webjars/", "/assets/").permitAll()
				.antMatchers("/h2-console/**").permitAll();

	}

}
