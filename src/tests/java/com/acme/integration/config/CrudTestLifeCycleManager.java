package com.acme.integration.config;


public class CrudTestLifeCycleManager implements QuarkusTestResourceLifecycleManager {
    // public static final PostgreSQLContainer<?> POSTGRES = new PostgreSQLContainer<>("postgres:13");

    // @Override
    // public Map<String, String> start() {
    //     POSTGRES.start();
    //     Map<String, String> properties = new HashMap<String, String>();

    //     properties.put("quarkus.datasource.jdbc.url", POSTGRES.getJdbcUrl());
    //     properties.put("quarkus.datasource.username", POSTGRES.getUsername());
    //     properties.put("quarkus.datasource.password", POSTGRES.getPassword());

    //     return properties;
    // }

    // @Override
    // public void stop() {
    //     if (POSTGRES != null && POSTGRES.isRunning()) {
    //         POSTGRES.stop();
    //     }
    // }
}
