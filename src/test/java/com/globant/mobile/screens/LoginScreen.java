package com.globant.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen{

    @AndroidFindBy(uiAutomator = "description(\"button-LOGIN\")")
    private WebElement login_btn;

    @AndroidFindBy(uiAutomator = "text(\"Sign up\")")
    private WebElement sign_up_btn;


    public LoginScreen(AppiumDriver appium_driver) {
        super(appium_driver);
    }

    public boolean checkLoginButtonVisibility(){
        return isTheElementVisible(this.login_btn,15);
    }

    public SignUpScreen clickOnSignUp(){
        click(this.sign_up_btn);
        return new SignUpScreen(getDriver());
    }

}
