package com.globant.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class FormScreen extends BaseScreen{

    @AndroidFindBy(uiAutomator = "text(\"Form components\")")
    private WebElement form_label;

    public FormScreen(AppiumDriver appium_driver) {
        super(appium_driver);
    }

    public boolean checkFormText(){
        return isTheElementVisible(this.form_label,10);
    }


}
