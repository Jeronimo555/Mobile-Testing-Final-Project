package com.globant.mobile.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

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

    /**
     * This method makes sure that a given ID's card is not visible.
     * @param expected_id The method checks that the card with this ID is hidden/invisible.
     * @return True if the card is hidden, False if it is not.
     */
    public boolean isCardIdHidden(String expected_id) {
        try {
            getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            List<WebElement> elements = getDriver().findElements(AppiumBy.id(expected_id));
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

    /**
     * Does a horizontal swipe and waits half a second to let the system breath.
     */
    public void swipeToNextCard(){
        try {
            horizontalSwipe();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Swipes each card, making sure that the previous one is hidden after the swipe
     * @param number_of_swipes the amount of times you wish to swipe
     * @return boolean value based on if the last card is visible.
     */
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

    /**
     * This method does a small, initial swipe to gain some wiggle room for the normal, larger swipes.
     * It then does a maximum of 3 swipes
     * @param max_swipes Maximum amount of swipes that it will do before failing to find the hidden text.
     * @return returns False if it fails to find the hidden text, True if it finds it before the max amount of swipes
     */
    public boolean scrollDownToHiddenText(int max_swipes){
        int current_swipes = 0;

        smallInitialVerticalSwipe();

        while (current_swipes < max_swipes) {
            try {
                if (isTheElementVisible(this.hidden_txt,1/2)) {
                    return true;
                }
                verticalSwipe();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // If it's not visible, scroll down
            current_swipes++;
        }

        // If we hit our max swipes and never returned true, the text isn't there
        return false;
    }
}
