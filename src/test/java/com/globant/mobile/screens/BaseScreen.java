package com.globant.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.WebElement;
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

    public BaseScreen(AppiumDriver appium_driver){
        this.driver = appium_driver;
        PageFactory.initElements(new AppiumFieldDecorator(appium_driver),this);
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


    public void horizontalSwipe(){
        int screenWidth = driver.manage().window().getSize().getWidth();
        int screenHeight = driver.manage().window().getSize().getHeight();

        //Calculate starting coordinates for the swipe
        int startX = (int) (screenWidth * 0.8); // Start at 80% on the right
        int endX = (int) (screenWidth * 0.2);   // End at 20% on the left
        int y = screenHeight / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        //Move to start -> Press down -> Drag to end -> Release
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startX,y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(600),PointerInput.Origin.viewport(),endX,y))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.BACK.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }


}
