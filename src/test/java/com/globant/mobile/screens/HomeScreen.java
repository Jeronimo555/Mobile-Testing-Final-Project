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

    /**
     * Clicks on the web view button in the bottom navigation bar.
     * @return A new WebViewScreen with its respective Appium driver.
     */
    public WebViewScreen clickOnWebView(){
        click(this.web_nav_btn);
        return new WebViewScreen(getDriver());
    }

    /**
     * Clicks on the login button in the bottom navigation bar.
     * @return A new LoginScreen with its respective Appium driver.
     */
    public LoginScreen clickOnLogin(){
        click(this.login_nav_btn);
        return new LoginScreen(getDriver());
    }

    /**
     * Clicks on the form button in the bottom navigation bar.
     * @return A new FormScreen with its respective Appium driver.
     */
    public FormScreen clickOnForm(){
        click(this.forms_nav_btn);
        return new FormScreen(getDriver());
    }

    /**
     * Clicks on the Swipe button in the bottom navigation bar.
     * @return A new SwipeScreen with its respective Appium driver.
     */
    public SwipeScreen clickOnSwipe(){
        click(this.swipe_nav_btn);
        return new SwipeScreen(getDriver());
    }

    /**
     * Clicks on the drag button in the bottom navigation bar.
     * @return A new DragScreen with its respective Appium driver.
     */
    public DragScreen clickOnDrag(){
        click(this.drag_nav_btn);
        return new DragScreen(getDriver());
    }

    /**
     * Clicks on the menu button in the bottom navigation bar.
     * @return A new MenuScreen with its respective Appium driver.
     */
    public MenuScreen clickOnMenu(){
        click(this.menu_nav_btn);
        return new MenuScreen(getDriver());
    }
}
