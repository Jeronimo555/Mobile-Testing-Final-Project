package com.globant.mobile.tests;

import com.globant.mobile.screens.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class NavigateToBottomBarTest extends BaseTest{

    @Test
    public void navigateToBottombarTest(){
        HomeScreen homeScreen = new HomeScreen(getDriver());
        boolean check_screen;

        //Check Web view
        WebViewScreen webview_screen = homeScreen.clickOnWebView();
        //check_screen = webview_screen.checkIOLogo();
        check_screen = webview_screen.checkLoadingText();

        Assert.assertTrue(check_screen, "The IO logo is missing.");

        //Check Login
        LoginScreen login_screen = homeScreen.clickOnLogin();
        check_screen = login_screen.checkLoginButtonVisibility();

        Assert.assertTrue(check_screen, "The Login button is missing.");

        //Check Forms
        FormScreen form_screen = homeScreen.clickOnForm();
        check_screen = form_screen.checkFormText();

        Assert.assertTrue(check_screen, "The Form text is missing.");

        //Check Swipe
        SwipeScreen swipe_screen = homeScreen.clickOnSwipe();
        check_screen = swipe_screen.checkSwipeText();

        Assert.assertTrue(check_screen, "The Swipe text is missing.");

        //Check Drag
        DragScreen drag_screen = homeScreen.clickOnDrag();
        check_screen = drag_screen.checkDragText();

        Assert.assertTrue(check_screen, "The Drag text is missing.");

        //Check Menu

        MenuScreen menu_screen = homeScreen.clickOnMenu();
        check_screen = menu_screen.checkMenuText();

        Assert.assertTrue(check_screen, "The Drag text is missing.");

        System.out.println("Test Complete!");
    }
}
