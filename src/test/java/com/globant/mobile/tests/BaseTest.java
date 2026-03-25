package com.globant.mobile.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    @BeforeMethod
    public AppiumDriver setup() {

        try {
            //Set up the exact same capabilities we used in the Inspector
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName("Android")
                    .setDeviceName("emulator-5554")
                    .setAppPackage("com.android.settings")
                    .setAppActivity(".Settings"); //Make sure to change this depending on the main activity of the app.

            URL url = new URL("http://127.0.0.1:4723");
            AppiumDriver appium_driver = new AppiumDriver(url,options);

            appium_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return appium_driver;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
