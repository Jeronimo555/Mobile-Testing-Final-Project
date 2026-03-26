package com.globant.mobile.tests;

import com.globant.mobile.screens.HomeScreen;
import org.testng.annotations.BeforeMethod;

public class SwipeTest extends BaseTest{

    @BeforeMethod(groups = {"SwipeTest"})
    public void preconditions(){
        HomeScreen home_screen = new HomeScreen(getDriver());
        home_screen.clickOnSwipe();
    }

    public void swipeTest(){
        
    }



}
