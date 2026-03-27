package com.globant.mobile.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.List;

public class SwipeScreen extends BaseScreen{

    @AndroidFindBy(uiAutomator = "text(\"Swipe horizontal\")")
    private WebElement swipe_text;

    @AndroidFindBy(uiAutomator = "resourceId(\"__CAROUSEL_ITEM_0__\")")
    private WebElement first_card;

    @AndroidFindBy(uiAutomator = "text(\"COMPATIBLE\")")
    private WebElement final_card;

    @AndroidFindBy(uiAutomator = "text(\"You found me!!!\")")
    private WebElement hidden_txt;

    public SwipeScreen(AppiumDriver appium_driver) {
        super(appium_driver);
    }

    public boolean checkSwipeText(){
        return isTheElementVisible(this.swipe_text,10);
    }

    public boolean isCardVisible(WebElement card) { return isTheElementVisible(card,1); }

    public boolean isCardIdHidden(String expectedId) {
        try {
            getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            List<WebElement> elements = getDriver().findElements(AppiumBy.id(expectedId));
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

            if (elements.isEmpty()) {
                return true;
            }

            return !elements.get(0).isDisplayed();
        } catch (Exception e) {
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            return true;
        }
    }

    public void swipeToNextCard(){
        try {
            horizontalSwipe(this.first_card);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean swipeToLastCard(int number_of_swipes){

        for (byte i = 0; i<number_of_swipes;i++){
            String currentCardId = "__CAROUSEL_ITEM_" + i + "__";

            swipeToNextCard();

            if (!isCardIdHidden(currentCardId)){
                return false;
            }
        }

        return isCardVisible(this.final_card);
    }

    public boolean scrollDownToHiddenText(){
        int maxSwipes = 3; // Failsafe so the test doesn't loop forever
        int currentSwipes = 0;

        smallInitialVerticalSwipe();

        while (currentSwipes < maxSwipes) {
            try {
                // Check if the text is visible on the current screen
                if (isTheElementVisible(this.hidden_txt,1/2)) {
                    return true;
                }
                verticalSwipe();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // If it's not visible, scroll down
            currentSwipes++;
        }

        // If we hit our max swipes and never returned true, the text isn't there
        return false;
    }


}
