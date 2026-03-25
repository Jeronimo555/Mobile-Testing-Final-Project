package com.globant.mobile.tests;

import com.globant.mobile.screens.HomeScreen;
import com.globant.mobile.screens.LoginScreen;
import com.globant.mobile.screens.SignUpScreen;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest{

    @Test
    public void signUpTest(){
        //Preconditions
        HomeScreen home_screen = new HomeScreen(getDriver());
        LoginScreen login_screen = home_screen.clickOnLogin();

        //Start
        SignUpScreen sign_up_screen = login_screen.clickOnSignUp();
    }



}
