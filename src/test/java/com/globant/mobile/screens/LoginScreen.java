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
    private WebElement login_upper_btn;

    //Top signup button
    @AndroidFindBy(uiAutomator = "text(\"Sign up\")")
    private WebElement sign_up_upper_btn;

    @AndroidFindBy(uiAutomator = "resourceId(\"com.wdiodemoapp:id/alert_title\")")
    private WebElement success_msg;

    @AndroidFindBy(uiAutomator = "text(\"Email\")")
    private WebElement sign_up_email_input;

    @AndroidFindBy(uiAutomator = "text(\"Password\")")
    private WebElement sign_up_password_input;

    @AndroidFindBy(uiAutomator ="text(\"Confirm password\")")
    private WebElement sign_up_conf_password_input;

    @AndroidFindBy(uiAutomator = "description(\"button-SIGN UP\")")
    private WebElement sign_up_form_btn;

    @AndroidFindBy(uiAutomator = "resourceId(\"android:id/message\")")
    private WebElement successful_sign_up_msg;

    @AndroidFindBy(uiAutomator = "resourceId(\"android:id/button1\")")
    private WebElement successful_sign_up_ok_btn;

    public LoginScreen(AppiumDriver appium_driver) {
        super(appium_driver);
    }

    public boolean checkLoginButtonVisibility(){
        return isTheElementVisible(this.login_upper_btn,15);
    }

    /**
     * This method clicks the upper Sign Up button that moves the user to the Sign Up Form
     */
    public void clickOnSignUp(){
        click(this.sign_up_upper_btn);
    }

    /**
     * This method clicks the upper Sign Up button that moves the user to the Login in Form
     */
    public void clickOnLogin(){
        click(this.login_upper_btn);
    }

    public void clickOnLoginFormBtn(){
        click(this.login_form_btn);
    }

    public boolean createUser(String email,String password){
        inputText(this.sign_up_email_input,email);
        inputText(this.sign_up_password_input,password);
        inputText(this.sign_up_conf_password_input,password);

        click(this.sign_up_form_btn);

        return isTheElementVisible(this.successful_sign_up_msg,5);
    }

    public void clickOnOkSucess(){
        click(this.successful_sign_up_ok_btn);
    }

    public boolean checkSuccessMsg(){
        return isTheElementVisible(this.success_msg,5);
    }

}
