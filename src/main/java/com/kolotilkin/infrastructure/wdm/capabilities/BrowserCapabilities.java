package com.kolotilkin.infrastructure.wdm.capabilities;

import com.kolotilkin.infrastructure.config.ConfigurationManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

public class BrowserCapabilities {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type", "start-maximized", "disable-infobars");

        if (ConfigurationManager.getInstance().isHeadlessBrowser()) {
            options.addArguments("--headless");
        }

        return options;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        // add more options

        return options;
    }

    public static InternetExplorerOptions getIEOptions() {
        InternetExplorerOptions options = new InternetExplorerOptions();

        options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

        return options;
    }
}
