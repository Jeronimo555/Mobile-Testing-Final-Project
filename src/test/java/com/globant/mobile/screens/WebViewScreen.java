package com.globant.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WebViewScreen extends BaseScreen{

    @AndroidFindBy(uiAutomator = "text(\"WebdriverIO\")")
    private WebElement io_logo;

    @AndroidFindBy(uiAutomator = "text(\"LOADING...\")")
    private WebElement loading_text;

    public WebViewScreen(AppiumDriver appium_driver) {
        super(appium_driver);
    }

    /**
     * Only use this method if the web view loads.
     * @return True if the IO logo is visible, False if not.
     */
    public boolean checkIOLogo(){
        return isTheElementVisible(this.io_logo,20);
    }

    /**
     * In case the web nav never loads, use this element instead of the logo.
     * @return True if the Loading text is visible, False if not.
     */
    public boolean checkLoadingText(){
        return isTheElementVisible(this.loading_text,10);
    }

}
