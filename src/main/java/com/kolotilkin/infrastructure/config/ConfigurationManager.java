package com.kolotilkin.infrastructure.config;

import java.util.Map;

public class ConfigurationManager {

    private static ConfigurationManager instance;

    private ConfigurationManager() {
    }

    public static ConfigurationManager getInstance() {
        if (instance == null)
            instance = new ConfigurationManager();

        return instance;
    }

    public String getTestEnv() {
        return getEnvironmentVariableOrDefault("testEnv", "production");
    }

    public String getRunOn() {
        return getEnvironmentVariableOrDefault("runOn", "local");
    }

    public String getTestBrowser() {
        return getEnvironmentVariableOrDefault("testBrowser", "chrome");
    }

    public Boolean isHeadlessBrowser() {
        String opt = getEnvironmentVariableOrDefault("ISHEADLESS", "false");
        System.out.println(opt);

        // DEbug info
        Map<String, String> envMap = System.getenv();

        for (String envName : envMap.keySet()) {
            System.out.format("%s = %s%n", envName, envMap.get(envName));
        }
        ///////////////////
        
        return opt.equals("true");
    }

    public String getCloudProvider() {
        return getEnvironmentVariableOrDefault("cloudProvider", "saucelabs");
    }
    private String getEnvironmentVariableOrDefault(String envVarName, String defaultValue) {
        return System.getenv(envVarName) == null || System.getenv(envVarName).isBlank() ? defaultValue : System.getenv(envVarName);
    }
}
