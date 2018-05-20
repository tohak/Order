package com.konovalov.order.service;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbProperties {
    private String url;
    private String user;
    private String password;

    public DbProperties() {
        InputStream stream=getClass().getClassLoader().getResourceAsStream("db.properties");
        Properties pr=new Properties();

        try {
            pr.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.url= pr.getProperty("db.url");
        this.user=pr.getProperty("db.user");
        this.password=pr.getProperty("db.password");

    }
    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
