package com.kolotilkin.infrastructure.wdm;

import org.openqa.selenium.WebDriver;

public interface WebDriverManager {

    WebDriver getWebDriver();

    void destroyWebDriver(WebDriver webDriver);
}
