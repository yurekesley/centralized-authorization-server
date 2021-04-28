package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.config.HibernateProperties;
import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.KeyDataSourceProperties;
import org.spcbrasil.jdbc.connection.PasswordFileSecurePoolDataSourceImplHikari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author yure.placido
 */
@Configuration
@EnableJpaRepositories(basePackages = OracleDataSourceConfig.REPOSITORIES_PACKAGE, entityManagerFactoryRef = "ordersEntityManagerFactory", transactionManagerRef = "ordersTransactionManager")
public class OracleDataSourceConfig {

	static final String REPOSITORIES_PACKAGE = "org.spcbrasil.cadastropositivo.centralizedauthorizationserver.datasource.oracle.repository";
	static final String REPOSITORIES_ENTITIES = "org.spcbrasil.cadastropositivo.centralizedauthorizationserver.datasource.oracle.entity";

	private static final String USER = "user";
	private static final String URL = "URL";
	private static final String MAX_STATEMENTS = "maxStatements";
	private static final String IMPLICIT_CACHING_ENABLED = "implicitCachingEnabled";

	private final HibernateProperties hibernateConfig;

	@Autowired
	public OracleDataSourceConfig(HibernateProperties hibernateConfig) {
		this.hibernateConfig = hibernateConfig;
	}

	@Bean
	@ConfigurationProperties(prefix = "datasource.oracle")
	public KeyDataSourceProperties oracleProperties() {
		return new KeyDataSourceProperties();
	}

	@Bean(name = "oracle")
	public DataSource oracle(KeyDataSourceProperties properties) // NOSONAR
			throws FileNotFoundException, SQLException {
		PasswordFileSecurePoolDataSourceImplHikari pf = new PasswordFileSecurePoolDataSourceImplHikari();
		pf.setDataSourceClassName(properties.getConnectionFactoryClassName());
		pf.setKeyfile(properties.getKeyfile());
		pf.setPasswordfile(properties.getPasswordfile());
		pf.setPoolName(properties.getConnectionpoolname());
		pf.setMaximumPoolSize(properties.getMaxPoolSize());
		pf.setMinimumIdle(properties.getMinPoolSize());
		pf.setMaxLifetime(600000L);
		pf.setIdleTimeout(300000L);
		pf.setConnectionTimeout(30000L);
		pf.setAutoCommit(false);
		pf.setRegisterMbeans(true);
		Properties p = new Properties();
		p.setProperty(IMPLICIT_CACHING_ENABLED, "true");
		p.setProperty(MAX_STATEMENTS, "100");
		p.setProperty(URL, properties.getJdbcUrl());
		p.setProperty(USER, properties.getJdbcUser());
		pf.setDataSourceProperties(p);
		return pf;
	}

	@Bean("oracleEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("oracle") DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
		factory.setPackagesToScan(OracleDataSourceConfig.REPOSITORIES_ENTITIES);
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto", hibernateConfig.getAuto());
		jpaProperties.put("hibernate.show-sql", hibernateConfig.getShowSql());
		factory.setJpaProperties(jpaProperties);
		return factory;
	}

	@Bean("oracleTransactionManager")
	public PlatformTransactionManager oracleTransactionManager(@Qualifier("oracle") DataSource dataSource) {
		EntityManagerFactory factory = entityManagerFactory(dataSource).getObject();
		return new JpaTransactionManager(factory);
	}

}
