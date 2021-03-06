package com.example.learn.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties("database")
public class DataBaseProperties {

    // @Value("${database.driverName}")
    private String driverName = null;

    // @Value("${database.url}")
    private String url = null;

    private String username = null;

    private String password = null;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    // @Value("${database.username}")
    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    //@Value("${database.password}")
    public void setPassword(String password) {
        this.password = password;
    }
}
