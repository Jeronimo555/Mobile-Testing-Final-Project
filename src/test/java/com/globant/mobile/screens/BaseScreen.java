package com.globant.mobile.screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class BaseScreen {

    private AppiumDriver driver;

    public BaseScreen(AppiumDriver appium_driver){
        this.driver = appium_driver;
    }

    /**
     * clicks element and adds description
     * @param element Web element to be clicked.
     */
    public void click(WebElement element){
        element.click();
    }
}
