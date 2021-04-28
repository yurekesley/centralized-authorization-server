package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.OracleModuleConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author yure.placido
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@Documented
@Import(OracleModuleConfiguration.class)
@Configuration
public @interface EnableOracleModule {

}
