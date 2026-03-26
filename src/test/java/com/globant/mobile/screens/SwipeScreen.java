package com.globant.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SwipeScreen extends BaseScreen{

    @AndroidFindBy(uiAutomator = "text(\"Swipe horizontal\")")
    private WebElement swipe_text;

    @AndroidFindBy(uiAutomator = "description(\"card\").instance(0)")
    private WebElement first_card;

    @AndroidFindBy(uiAutomator = "description(\"card\").instance(1)")
    private WebElement second_card;

    @AndroidFindBy(uiAutomator = "description(\"card\")")
    private WebElement final_card;

    @AndroidFindBy(uiAutomator = "text(\"You found me!!!\")")
    private WebElement hidden_txt;

    public SwipeScreen(AppiumDriver appium_driver) {
        super(appium_driver);
    }

    public boolean checkSwipeText(){
        return isTheElementVisible(this.swipe_text,10);
    }

    public void swipeToNextCard(){
        horizontalSwipe();
        isTheElementVisible(first_card,1/2);
    }

    public boolean scrollDownToHiddenText(){
        return true;
    }


}
