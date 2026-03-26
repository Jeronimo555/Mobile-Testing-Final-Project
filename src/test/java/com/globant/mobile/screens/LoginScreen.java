package com.globant.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen{

    //Form login button
    @AndroidFindBy(uiAutomator = "description(\"button-LOGIN\")")
    private WebElement login_form_btn;

    //Top login button
    @AndroidFindBy(uiAutomator = "text(\"Login\").instance(0)")
    private WebElement login_btn;

    @AndroidFindBy(uiAutomator = "text(\"Sign up\")")
    private WebElement sign_up_btn;

    @AndroidFindBy(uiAutomator = "text(\"Email\")")
    private WebElement email_input;

    @AndroidFindBy(uiAutomator = "text(\"Password\")")
    private WebElement password_input;

    @AndroidFindBy(uiAutomator = "resourceId(\"com.wdiodemoapp:id/alert_title\")")
    private WebElement success_msg;

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

    public void clickOnLogin(){
        click(this.login_btn);
    }

    public void clickOnLoginFormBtn(){
        click(this.login_form_btn);
    }

    public boolean checkSuccessMsg(){
        return isTheElementVisible(this.success_msg,10);
    }

}
