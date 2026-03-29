package com.globant.mobile.tests;

import com.globant.mobile.screens.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BottomBarNavigationTest extends BaseTest{

    //There is no precondition because the driver's activity sets the page to always start in the home screen.
    @Test
    public void bottomBarNavigationTest(){
        HomeScreen homeScreen = new HomeScreen(getDriver());

        //Check Web view
        WebViewScreen webview_screen = homeScreen.clickOnWebView();
        Assert.assertTrue(webview_screen.checkLoadingText(), "The Loading logo is missing.");

        //Check Login
        LoginScreen login_screen = homeScreen.clickOnLogin();
        Assert.assertTrue(login_screen.checkLoginButtonVisibility(), "The Login button is missing.");

        //Check Forms
        FormScreen form_screen = homeScreen.clickOnForm();
        Assert.assertTrue(form_screen.checkFormText(), "The Form text is missing.");

        //Check Swipe
        SwipeScreen swipe_screen = homeScreen.clickOnSwipe();
        Assert.assertTrue(swipe_screen.checkSwipeText(), "The Swipe text is missing.");

        //Check Drag
        DragScreen drag_screen = homeScreen.clickOnDrag();
        Assert.assertTrue(drag_screen.checkDragText(), "The Drag text is missing.");

        //Check Menu
        MenuScreen menu_screen = homeScreen.clickOnMenu();
        Assert.assertTrue(menu_screen.checkMenuText(), "The Drag text is missing.");

        System.out.println("Test Complete!");
    }
}
