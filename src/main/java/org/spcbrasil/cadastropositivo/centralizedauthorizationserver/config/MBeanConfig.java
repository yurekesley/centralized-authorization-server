package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;

/**
 * @author yure.placido
 */
@Configuration
public class MBeanConfig {

    @Bean
    public MBeanExporter exporter() {
        final MBeanExporter exporter = new MBeanExporter();
        exporter.setExcludedBeans(new String[]{"oracle"});
        return exporter;
    }
}
