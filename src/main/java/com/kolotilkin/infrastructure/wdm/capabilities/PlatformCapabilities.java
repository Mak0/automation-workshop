package com.kolotilkin.infrastructure.wdm.capabilities;

import com.kolotilkin.infrastructure.config.ConfigurationManager;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PlatformCapabilities {

    public static DesiredCapabilities defaultsCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();

//        caps.setCapability(CapabilityType.PLATFORM_NAME, ConfigurationManager.getInstance().getCloudPlatform());
//        caps.setCapability("platformVersion", ConfigurationManager.getInstance().getCloudPlatformVersion());
//        caps.setCapability("seleniumVersion", ConfigurationManager.getInstance().getSeleniumVersion());
//        caps.setCapability("screenResolution", ConfigurationManager.getInstance().getScreenResolution());
//        caps.setCapability("record-screen", true);

        return caps;
    }

    public static DesiredCapabilities mobileCapabilities() {
        return null;
    }

    public static DesiredCapabilities getIosCapabilities() {
        return null;
    }

    public static DesiredCapabilities getAndroidCapabilities() {
        return null;
    }
}
