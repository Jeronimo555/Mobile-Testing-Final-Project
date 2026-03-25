package com.globant.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DragScreen extends BaseScreen{

    @AndroidFindBy(uiAutomator = "text(\"Drag and Drop\")")
    private WebElement drag_text;

    public DragScreen(AppiumDriver appium_driver) {
        super(appium_driver);
    }

    public boolean checkDragText(){
        return isTheElementVisible(this.drag_text,10);
    }


}
