package com.globant.mobile.tests;

import com.globant.mobile.screens.HomeScreen;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest{

    @Test
    public void signUpTest(){
        //Preconditions
        HomeScreen home_screen = new HomeScreen(getDriver());
        home_screen.clickOnLogin();


    }



}
