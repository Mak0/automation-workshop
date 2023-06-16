package com.kolotilkin.infrastructure.wdm.factory;

import com.kolotilkin.infrastructure.config.ConfigurationManager;
import com.kolotilkin.infrastructure.wdm.capabilities.BrowserCapabilities;
import com.kolotilkin.infrastructure.wdm.enums.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalWebDriverFactory implements WebDriverFactory {

    @Override
    public WebDriver create() {
        WebDriverType type = WebDriverType.valueOf(ConfigurationManager.getInstance().getTestBrowser().toUpperCase());
        switch (type) {
            case CHROME:
                return new ChromeDriver(BrowserCapabilities.getChromeOptions());
            case FIREFOX:
                return new FirefoxDriver();
            case EDGE:
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Not supported browser type");
        }
    }
}
