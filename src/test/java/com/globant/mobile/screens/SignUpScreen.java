package com.globant.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SignUpScreen extends BaseScreen{

    @AndroidFindBy(uiAutomator = "text(\"Email\")")
    private WebElement email_input;

    @AndroidFindBy(uiAutomator = "text(\"Password\")")
    private WebElement password_input;

    @AndroidFindBy(uiAutomator ="text(\"Confirm password\")")
    private WebElement conf_password_input;

    @AndroidFindBy(uiAutomator = "description(\"button-SIGN UP\")")
    private WebElement sign_up_btn;

    @AndroidFindBy(uiAutomator = "resourceId(\"android:id/message\")")
    private WebElement successful_sign_up_msg;

    public SignUpScreen(AppiumDriver appium_driver) {
        super(appium_driver);
    }

    public boolean createUser(String email,String password){
        inputText(this.email_input,email);
        inputText(this.password_input,password);
        inputText(this.conf_password_input,password);

        click(this.sign_up_btn);

        return isTheElementVisible(this.successful_sign_up_msg,10);
    }
}
