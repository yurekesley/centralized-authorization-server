package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.oauth;

import javax.sql.DataSource;

import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.config.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * @author yure.placido
 *
 */
@Configuration
@EnableAuthorizationServer
@EnableConfigurationProperties(SecurityProperties.class)
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	private final DataSource dataSource;
	private final AuthenticationManager authenticationManager;

	private final JwtAccessTokenConverter jwtAccessTokenConverter;
	private final TokenStore tokenStore;

	public AuthorizationServerConfiguration(final DataSource dataSource, AuthenticationManager authenticationManager,
			JwtAccessTokenConverter jwtAccessTokenConverter, TokenStore tokenStore) {
		this.dataSource = dataSource;
		this.authenticationManager = authenticationManager;
		this.jwtAccessTokenConverter = jwtAccessTokenConverter;
		this.tokenStore = tokenStore;
	}

	@Override
	public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
		clients.jdbc(this.dataSource);
	}

	@Override
	public void configure(final AuthorizationServerEndpointsConfigurer endpoints) {
		endpoints.authenticationManager(this.authenticationManager)
				.accessTokenConverter(this.jwtAccessTokenConverter)
				.tokenStore(this.tokenStore);
	}

	@Override
	public void configure(final AuthorizationServerSecurityConfigurer oauthServer) {
		oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

}
