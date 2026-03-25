package com.globant.mobile.tests;

import com.globant.mobile.screens.HomeScreen;
import com.globant.mobile.screens.LoginScreen;
import com.globant.mobile.screens.WebViewScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigateToBottomBarTest extends BaseTest{

    @Test
    public void navigateToBottombarTest(){
        HomeScreen homeScreen = new HomeScreen(getDriver());
        boolean check_screen;

        LoginScreen login_screen = homeScreen.clickOnLogin();
        check_screen = login_screen.checkLoginButtonVisibility();

        Assert.assertTrue(check_screen, "The Login button is missing.");
    }

}
