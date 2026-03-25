package com.globant.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public void isVisible(WebElement element){
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
}
