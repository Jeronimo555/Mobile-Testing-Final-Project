package com.globant.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MenuScreen extends BaseScreen{
    @AndroidFindBy(uiAutomator = "text(\"Menu\")")
    private WebElement menu_text;

    public MenuScreen(AppiumDriver appium_driver) {
        super(appium_driver);
    }

    public boolean checkMenuText(){
        return isTheElementVisible(this.menu_text,10);
    }

}
