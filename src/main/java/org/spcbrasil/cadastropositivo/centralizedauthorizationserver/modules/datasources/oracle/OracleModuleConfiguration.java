package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yure.placido
 *
 */
@Configuration
@ComponentScan(basePackages = "org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle")
@ConditionalOnProperty(name = "app.module.oracle.enabled", 
havingValue = "true", matchIfMissing = false)
public class OracleModuleConfiguration {

}
