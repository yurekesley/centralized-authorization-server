package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.config;

import lombok.Data;

public @Data
class KeyDataSourceProperties {

    private String connectionFactoryClassName;
    private String keyfile;
    private String passwordfile;
    private String connectionpoolname;
    private Integer maxPoolSize;
    private Integer minPoolSize;
    private String jdbcUrl;
    private String jdbcUser;
    private String message;
    private Boolean hibernateShowSQL;
}
