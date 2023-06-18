package com.kolotilkin.infrastructure.config;

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
        return opt.equals("true");
    }

    public String getCloudProvider() {
        return getEnvironmentVariableOrDefault("cloudProvider", "saucelabs");
    }
    private String getEnvironmentVariableOrDefault(String envVarName, String defaultValue) {
        return System.getenv(envVarName) == null || System.getenv(envVarName).isBlank() ? defaultValue : System.getenv(envVarName);
    }
}
