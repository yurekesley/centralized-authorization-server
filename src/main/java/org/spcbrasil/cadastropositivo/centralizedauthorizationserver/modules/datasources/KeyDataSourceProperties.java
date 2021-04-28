package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources;

/**
 * @author yure.placido
 */
public class KeyDataSourceProperties {

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

    public String getConnectionFactoryClassName() {
        return connectionFactoryClassName;
    }

    public void setConnectionFactoryClassName(String connectionFactoryClassName) {
        this.connectionFactoryClassName = connectionFactoryClassName;
    }

    public String getKeyfile() {
        return keyfile;
    }

    public void setKeyfile(String keyfile) {
        this.keyfile = keyfile;
    }

    public String getPasswordfile() {
        return passwordfile;
    }

    public void setPasswordfile(String passwordfile) {
        this.passwordfile = passwordfile;
    }

    public String getConnectionpoolname() {
        return connectionpoolname;
    }

    public void setConnectionpoolname(String connectionpoolname) {
        this.connectionpoolname = connectionpoolname;
    }

    public Integer getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(Integer maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public Integer getMinPoolSize() {
        return minPoolSize;
    }

    public void setMinPoolSize(Integer minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcUser() {
        return jdbcUser;
    }

    public void setJdbcUser(String jdbcUser) {
        this.jdbcUser = jdbcUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getHibernateShowSQL() {
        return hibernateShowSQL;
    }

    public void setHibernateShowSQL(Boolean hibernateShowSQL) {
        this.hibernateShowSQL = hibernateShowSQL;
    }

}
