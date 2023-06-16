package com.kolotilkin.infrastructure.base;

import com.kolotilkin.infrastructure.wdm.DefaultWebDriverManager;
import com.kolotilkin.infrastructure.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;

@RunWith(JUnit4.class)
public abstract class TestBase {

    private WebDriverManager wdm;

    protected WebDriver webDriver;

    @Before
    public void setUp() {
        wdm = new DefaultWebDriverManager();
        webDriver = wdm.getWebDriver();

        beforeTest();
    }

    @After
    public void cleanUp() {
        afterTest();
        wdm.destroyWebDriver(webDriver);
    }

    protected void beforeTest() {}

    protected void afterTest() {}


}
