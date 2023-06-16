package com.kolotilkin.infrastructure.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class SeleniumUtils {

    private final WebDriver webDriver;
    private final String parentWindowHandle;

    public SeleniumUtils(WebDriver webDriver) {
        this.webDriver = webDriver;
        parentWindowHandle = webDriver.getWindowHandle();
    }

    public void switchToWindow(String windowTitle) {
        Set<String> windowHandles =  webDriver.getWindowHandles();

        if (windowHandles.size() <= 1) {
            throw new RuntimeException("New window was not opened");
        }

        for(String handle: windowHandles) {
            webDriver.switchTo().window(handle);
            if (webDriver.getTitle().equals(windowTitle)) {
                return;
            }
        }
        throw new RuntimeException("Window with title '" + windowTitle +"' was not found");
    }

    public void switchToParent() {
        try {
            webDriver.switchTo().window(parentWindowHandle);
        } catch (Exception ex) {
            throw new RuntimeException("Unable to switch to parent window: " + ex);
        }
    }

    public void closeAllExtraWindows() {
        Set<String> windowHandles =  webDriver.getWindowHandles();

        if (windowHandles.size() <= 1) {
            return;
        }

        for(String handle: windowHandles) {
            webDriver.switchTo().window(handle);
            if (!handle.equals(parentWindowHandle)) {
                webDriver.switchTo().window(handle);
                webDriver.close();
            }
        }

        webDriver.switchTo().window(parentWindowHandle);
    }

    public void confirmAlert() {
        webDriver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        webDriver.switchTo().alert().dismiss();
    }

    public void takeScreenshot(String filename) {
        filename = filename.endsWith(".png") ? filename : filename+".png";
        try {
            TakesScreenshot screenshot = (TakesScreenshot) webDriver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("screenshots/" + filename);
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
