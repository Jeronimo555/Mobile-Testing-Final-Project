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
        Assert.assertTrue(this.swipe_screen.swipeToLastCard(5),"Last card should be visible.");

        //Now to scroll down to the hidden text.
        boolean check_screen = swipe_screen.scrollDownToHiddenText(3);
        Assert.assertTrue(check_screen,"This hidden text is not visible");
    }
}
