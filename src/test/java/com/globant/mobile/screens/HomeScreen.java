package com.globant.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen{

    @AndroidFindBy(uiAutomator = "description(\"Webview\")")
    private WebElement web_nav_btn;

    @AndroidFindBy(uiAutomator = "description(\"Login\")")
    private WebElement login_nav_btn;

    public HomeScreen(AppiumDriver appium_driver) {
        super(appium_driver);
    }

    public WebViewScreen clickOnWebView(){
        click(this.web_nav_btn);
        return new WebViewScreen(getDriver());
    }

    public LoginScreen clickOnLogin(){
        click(this.login_nav_btn);
        return new LoginScreen(getDriver());
    }

}
