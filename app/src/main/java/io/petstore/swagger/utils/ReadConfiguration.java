package io.petstore.swagger.utils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;

public class ReadConfiguration {

    private static final EnvironmentVariables CONF = SystemEnvironmentVariables.createEnvironmentVariables();

    private ReadConfiguration() {
        throw new IllegalStateException("Utility class");
    }

    public static String getEndpoint(String endpoint) {
        return EnvironmentSpecificConfiguration
                .from(CONF)
                .getProperty("endpoint." + endpoint);
    }

    public static String getUrl(String url) {
        return EnvironmentSpecificConfiguration
                .from(CONF)
                .getProperty("restapi." + url);
    }

}
