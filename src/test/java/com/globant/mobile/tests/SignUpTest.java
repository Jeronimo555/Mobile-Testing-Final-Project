package com.globant.mobile.tests;

import com.globant.mobile.screens.HomeScreen;
import com.globant.mobile.screens.LoginScreen;
import com.globant.mobile.utils.DataGenerator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest{
    private LoginScreen login_screen;


    @BeforeMethod(groups = {"SignUpTest"})
    public void preconditions(){
        HomeScreen home_screen = new HomeScreen(getDriver());
        this.login_screen = home_screen.clickOnLogin();
    }

    @Test(groups = {"SignUpTest"})
    public void signUpTest(){
        this.login_screen.clickOnSignUp();

        String test_email = DataGenerator.generateRandomEmail();
        String test_password = "SecurePassword123!";
        boolean check_text = this.login_screen.createUser(test_email,test_password);

        Assert.assertTrue(check_text,"The text does not display a success message");
    }



}
