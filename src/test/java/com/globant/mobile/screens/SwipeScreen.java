package com.globant.mobile.screens;

import io.appium.java_client.AppiumBy;
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

    public boolean isFirstCardVisible() { return isTheElementVisible(first_card,3); }
    public boolean isSecondCardVisible() { return isTheElementVisible(second_card,3); }
    public boolean isLastCardVisible() { return isTheElementVisible(final_card,3); }

    public void swipeToNextCard(){
        try {
            horizontalSwipe(this.first_card);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void swipeToLastCard(byte number_of_swipes){
        while(number_of_swipes != 0){
            swipeToNextCard();
            number_of_swipes--;
        }
    }


    public boolean scrollDownToHiddenText(){
        int maxSwipes = 3; // Failsafe so the test doesn't loop forever
        int currentSwipes = 0;

        smallInitialVerticalSwipe();

        while (currentSwipes < maxSwipes) {

            // Check if the text is visible on the current screen
            if (isTheElementVisible(this.hidden_txt,1/2)) {
                return true;
            }

            try {

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
