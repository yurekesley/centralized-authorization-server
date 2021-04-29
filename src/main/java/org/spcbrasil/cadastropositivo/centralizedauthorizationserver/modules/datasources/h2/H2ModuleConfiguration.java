package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.h2;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.h2")
@ConditionalOnProperty(name = "app.module.h2.enabled", havingValue = "true", matchIfMissing = false)
public class H2ModuleConfiguration {

}
