package com.globant.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

@Data
public class BaseScreen {

    private AppiumDriver driver;
    private int screen_width;
    private int screen_height;

    public BaseScreen(AppiumDriver appium_driver){
        this.driver = appium_driver;
        PageFactory.initElements(new AppiumFieldDecorator(appium_driver),this);

        setScreenDimension(appium_driver);
    }

    /**
     * Sets the screen's dimension using Appium's own methods.
     * @param appium_driver Standard Appium driver
     */
    public void setScreenDimension(AppiumDriver appium_driver){
        this.screen_width = appium_driver.manage().window().getSize().getWidth();
        this.screen_height = appium_driver.manage().window().getSize().getHeight();
    }

    /**
     * clicks element and adds description
     * @param element Web element to be clicked.
     */
    public void click(WebElement element){
        try{
            element.click();
        }
        catch (Exception e){
            throw new RuntimeException("The chose element was not found");
        }
    }

    /**
     * Sends a specified string to a web element.
     * @param element Web element which will receive the input
     * @param value the value that you want to input
     */
    public void inputText(WebElement element,String value){
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            throw new RuntimeException("The element could not be found");
        }
    }

    /**
     * Checks if a given web element is visible.
     * @param element Web Element to check.
     * @param seconds The amount of time the method waits before concluding that it is not visible.
     * @return True if the element is visible, False if not.
     */
    public boolean isTheElementVisible(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(seconds));

        try {
            WebElement element_found = wait.until(ExpectedConditions.visibilityOf(element));
            return element_found != null;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Basic horizontal swipe. It starts at 92% of the screen's width and ends at 1%.
     * Vertically, it always does the swipe at half the screen's height.
     * Finger moves to specified position -> finger moves down -> finger drags to the left -> short pause -> finger lets go.
     */
    public void horizontalSwipe(){
            int startX = (int) (this.screen_width * 0.92); // Start at 92% (Near right edge)
            int endX = (int) (this.screen_width * 0.01);   // End at 20% (Near left edge)
            int y = this.screen_height / 2;

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

            Sequence swipe = new Sequence(finger, 1)
                    .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y))
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, y))
                    .addAction(new Pause(finger, Duration.ofMillis(200)))
                    .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            this.driver.perform(Collections.singletonList(swipe));
    }

    /**
     * General vertical swipe method, can be called whenever you need to do a vertical swipe.
     * @param start_x Starting X position
     * @param start_y Starting Y position
     * @param end_x Final X position
     * @param end_y Final Y position
     * @param duration Duration of the swipe.
     */
    public void executeVerticalSwipe(int start_x, int start_y, int end_x, int end_y, Duration duration) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start_x, start_y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(duration, PointerInput.Origin.viewport(), end_x, end_y))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        this.driver.perform(Collections.singletonList(swipe));
    }

    /**
     * Small, initial swipe that clears the way and gives the screen more space to drag the finger around.
     */
    public void smallInitialVerticalSwipe() {
        int safe_x = (int) (this.screen_width * 0.05); // 5% safe edge
        int start_y = (int) (this.screen_height * 0.30);
        int end_y = (int) (this.screen_height * 0.10);

        executeVerticalSwipe(safe_x, start_y, safe_x, end_y, Duration.ofMillis(300));
    }

    /**
     * General swipe movement. Starts at 80% of the screen's height and ends at 20%.
     */
    public void verticalSwipe() {
        int safe_x = (int) (this.screen_width * 0.05); // 5% safe edge
        int start_y = (int) (this.screen_height * 0.80);
        int end_y = (int) (this.screen_height * 0.20);

        executeVerticalSwipe(safe_x, start_y, safe_x, end_y, Duration.ofMillis(500));
    }
}
