package org.eastnets.service;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EMFProvider {

    private static final EntityManagerFactory emf;

    static {
        Map<String, String> dbProps = new HashMap<>();
        try {
            Properties props = new Properties();
            props.load(EMFProvider.class.getClassLoader().getResourceAsStream("config.properties"));

            dbProps.put("jakarta.persistence.jdbc.url", props.getProperty("db.url"));
            dbProps.put("jakarta.persistence.jdbc.user", props.getProperty("db.user"));
            dbProps.put("jakarta.persistence.jdbc.password", props.getProperty("db.password"));
            dbProps.put("jakarta.persistence.jdbc.driver", "org.postgresql.Driver");
            dbProps.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            dbProps.put("hibernate.hbm2ddl.auto", "update");
            dbProps.put("hibernate.show_sql", "true");

        } catch (IOException e) {
            throw new RuntimeException("Failed to load DB config", e);
        }

        emf = Persistence.createEntityManagerFactory("libraryPU", dbProps);
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }
}