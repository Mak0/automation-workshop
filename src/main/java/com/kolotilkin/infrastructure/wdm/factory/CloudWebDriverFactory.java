package com.kolotilkin.infrastructure.wdm.factory;

import com.kolotilkin.infrastructure.config.ConfigurationManager;
import com.kolotilkin.infrastructure.wdm.capabilities.BrowserCapabilities;
import com.kolotilkin.infrastructure.wdm.capabilities.PlatformCapabilities;
import com.kolotilkin.infrastructure.wdm.enums.CloudProvider;
import com.kolotilkin.infrastructure.wdm.enums.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CloudWebDriverFactory implements WebDriverFactory {

    public WebDriver create() {

        String username = ""; //ConfigurationManager.getInstance().getCloudUsername();
        String password = ""; //ConfigurationManager.getInstance().getCloudPassword();

        CloudProvider provider = CloudProvider.valueOf(ConfigurationManager.getInstance().getCloudProvider().toUpperCase());
        String cloudUrl = "";
        switch (provider) {
            case BROWSERSTACK:
                cloudUrl = "https://" + username + ":" + password + "@hub-cloud.browserstack.com/wd/hub";
                break;
            case SAUCELABS:
                cloudUrl = "http://" + username + ":" + password + "@ondemand.saucelabs.com:80/wd/hub";
                break;
            default:
                throw new IllegalArgumentException();
        }

        WebDriverType wdType = WebDriverType.valueOf(ConfigurationManager.getInstance().getTestBrowser().toUpperCase());
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.merge(PlatformCapabilities.defaultsCapabilities());

        switch (wdType) {
            case FIREFOX:
                caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");
                caps.setCapability(CapabilityType.BROWSER_VERSION, "100");
                caps.merge(BrowserCapabilities.getFirefoxOptions());
                break;
            case EDGE:
                caps.setCapability(CapabilityType.BROWSER_NAME, "IE");
                caps.setCapability(CapabilityType.BROWSER_VERSION, "11");
                caps.merge(BrowserCapabilities.getIEOptions());
                break;
            case CHROME:
                caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                caps.setCapability(CapabilityType.BROWSER_VERSION, "101");
                caps.merge(BrowserCapabilities.getChromeOptions());
                break;
            default:
                throw new IllegalArgumentException();
        }

        try {
            return new RemoteWebDriver(new URL(cloudUrl), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
