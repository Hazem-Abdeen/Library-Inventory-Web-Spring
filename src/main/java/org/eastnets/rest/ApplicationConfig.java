package org.eastnets.rest;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")  // All your REST APIs will start with /api
public class ApplicationConfig extends Application {
}
