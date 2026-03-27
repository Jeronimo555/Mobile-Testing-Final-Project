package com.globant.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.Dimension;
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
    private int screenWidth;
    private int screenHeight;

    public BaseScreen(AppiumDriver appium_driver){
        this.driver = appium_driver;
        PageFactory.initElements(new AppiumFieldDecorator(appium_driver),this);

        this.screenWidth = appium_driver.manage().window().getSize().getWidth();
        this.screenHeight = appium_driver.manage().window().getSize().getHeight();
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
     *
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

    public boolean isTheElementVisible(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(seconds));

        try {
            WebElement element_found = wait.until(ExpectedConditions.visibilityOf(element));
            return element_found != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementHidden(WebElement element) {
        try {
            return !isTheElementVisible(element,1);
        } catch (Exception e) {
            return true;
        }
    }


    public void horizontalSwipe(WebElement element){
            // 1. Get the dimensions of the entire device screen
            Dimension screenSize = this.driver.manage().window().getSize();

            // 2. Calculate X coordinates based on screen percentages
            int startX = (int) (this.screenWidth * 0.92); // Start at 80% (Near right edge)
            int endX = (int) (this.screenWidth * 0.01);   // End at 20% (Near left edge)

            // 3. Set the Y coordinate to the middle of the screen
            int y = this.screenHeight / 2;

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);

            // Move to the starting position and press down
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

            // Execute the fast flick (200ms) to trigger carousel momentum
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, y));
            swipe.addAction(new Pause(finger, Duration.ofMillis(200)));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            this.driver.perform(Collections.singletonList(swipe));
    }

    public void executeSwipe(int startX, int startY, int endX, int endY, Duration duration) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(finger.createPointerMove(duration, PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        this.driver.perform(Collections.singletonList(swipe));
    }

    public void smallInitialVerticalSwipe() {
        Dimension screenSize = this.driver.manage().window().getSize();
        int safeX = (int) (this.screenWidth * 0.05); // 5% safe edge

        // Start near the top (30% down the screen) and flick up to 10%
        int startY = (int) (this.screenHeight * 0.30);
        int endY = (int) (this.screenHeight * 0.10);

        // Fast, short flick
        executeSwipe(safeX, startY, safeX, endY, Duration.ofMillis(300));
    }

    public void verticalSwipe() {
        Dimension screenSize = this.driver.manage().window().getSize();
        int safeX = (int) (this.screenWidth * 0.05); // 5% safe edge

        // Now that we have leeway, we can safely start at 80% and drag to 20%
        int startY = (int) (this.screenHeight * 0.80);
        int endY = (int) (this.screenHeight * 0.20);

        // Standard smooth scroll
        executeSwipe(safeX, startY, safeX, endY, Duration.ofMillis(500));
    }
}
