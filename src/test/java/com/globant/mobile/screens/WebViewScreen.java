package com.globant.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WebViewScreen extends BaseScreen{

    @AndroidFindBy(uiAutomator = "text(\"WebdriverIO\")")
    private WebElement io_logo;

    public WebViewScreen(AppiumDriver appium_driver) {
        super(appium_driver);
    }

    public boolean checkIOLogo(){
        return isTheElementVisible(this.io_logo,20);
    }

}
