package com.venkat.moneytransfer.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.venkat.moneytransfer.rest.AccountController;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("resources")
class ApplicationConfig extends ResourceConfig {

    ApplicationConfig() {
        packages("com.venkat.moneytransfer");
        register(JacksonFeature.class);
        register(AccountController.class);
    }
}
