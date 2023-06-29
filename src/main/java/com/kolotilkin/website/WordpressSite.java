package com.kolotilkin.website;

import org.openqa.selenium.WebDriver;

public class WordpressSite {

    private final WebDriver webDriver;

    public WordpressSite(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open() {
        webDriver.get("http://qaworkshop.totalh.net");
    }
}
