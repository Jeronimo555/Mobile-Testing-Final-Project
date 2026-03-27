package com.globant.mobile.tests;

import com.globant.mobile.screens.HomeScreen;
import com.globant.mobile.screens.SwipeScreen;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwipeTest extends BaseTest{
    private SwipeScreen swipe_screen;

    @BeforeMethod(groups = {"SwipeTest"})
    public void preconditions(){
        HomeScreen home_screen = new HomeScreen(getDriver());
        this.swipe_screen = home_screen.clickOnSwipe();
    }

    @Test(groups = {"SwipeTest"})
    public void swipeTest(){

        //Simple smoke test
        Assert.assertTrue(this.swipe_screen.isFirstCardVisible(),"First card should be visible initially.");

        //I had to count them manually since there is not way to get the number using a locator.
        this.swipe_screen.swipeToLastCard((byte) 5);
        Assert.assertTrue(this.swipe_screen.isLastCardVisible(),"Last card should be visible.");

        //Now to scroll down to the hidden text.
        boolean check_screen = swipe_screen.scrollDownToHiddenText();
        Assert.assertTrue(check_screen,"This hidden text is not visible");
    }



}
