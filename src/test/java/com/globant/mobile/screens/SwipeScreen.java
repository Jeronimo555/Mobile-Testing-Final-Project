package com.globant.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SwipeScreen extends BaseScreen{

    @AndroidFindBy(uiAutomator = "text(\"Swipe horizontal\")")
    private WebElement swipe_text;

    public SwipeScreen(AppiumDriver appium_driver) {
        super(appium_driver);
    }

    public boolean checkSwipeText(){
        return isTheElementVisible(this.swipe_text,10);
    }

}
