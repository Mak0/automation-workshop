package com.kolotilkin.infrastructure.wdm;

import com.kolotilkin.infrastructure.config.ConfigurationManager;
import com.kolotilkin.infrastructure.wdm.enums.RunOn;
import com.kolotilkin.infrastructure.wdm.factory.CloudWebDriverFactory;
import com.kolotilkin.infrastructure.wdm.factory.LocalWebDriverFactory;
import com.kolotilkin.infrastructure.wdm.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class DefaultWebDriverManager implements WebDriverManager {

    @Override
    public WebDriver getWebDriver() {
        WebDriverFactory factory;

        RunOn runOn = RunOn.valueOf(ConfigurationManager.getInstance().getRunOn().toUpperCase());
        switch (runOn) {
            case LOCAL:
                factory = new LocalWebDriverFactory();
                break;
            case CLOUD:
                factory = new CloudWebDriverFactory();
                break;
            case REMOTE:
            default:
                throw new IllegalArgumentException("Not supported");
        }

        return factory.create();
    }

    @Override
    public void destroyWebDriver(WebDriver webDriver) {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
