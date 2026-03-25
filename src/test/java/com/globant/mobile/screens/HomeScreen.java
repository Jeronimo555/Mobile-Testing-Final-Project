package com.globant.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen{

    @AndroidFindBy(uiAutomator = "description(\"Webview\")")
    private WebElement web_nav_btn;

    @AndroidFindBy(uiAutomator = "description(\"Login\")")
    private WebElement login_nav_btn;

    @AndroidFindBy(uiAutomator = "description(\"Forms\")")
    private WebElement forms_nav_btn;

    @AndroidFindBy(uiAutomator = "description(\"Swipe\")")
    private WebElement swipe_nav_btn;

    @AndroidFindBy(uiAutomator = "description(\"Drag\")")
    private WebElement drag_nav_btn;

    @AndroidFindBy(uiAutomator = "description(\"Menu\")")
    private WebElement menu_nav_btn;

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

    public FormScreen clickOnForm(){
        click(this.forms_nav_btn);
        return new FormScreen(getDriver());
    }

    public SwipeScreen clickOnSwipe(){
        click(this.swipe_nav_btn);
        return new SwipeScreen(getDriver());
    }

    public DragScreen clickOnDrag(){
        click(this.drag_nav_btn);
        return new DragScreen(getDriver());
    }

    public MenuScreen clickOnMenu(){
        click(this.menu_nav_btn);
        return new MenuScreen(getDriver());
    }

}
