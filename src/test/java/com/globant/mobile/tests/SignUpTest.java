package com.globant.mobile.tests;

import com.globant.mobile.screens.HomeScreen;
import com.globant.mobile.screens.LoginScreen;
import com.globant.mobile.screens.SignUpScreen;
import com.globant.mobile.utils.DataGenerator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest{

    private LoginScreen login_screen;
    private String test_email;
    private String test_password = "SecurePassword123!";

    @BeforeMethod()
    public void preconditions(){
        HomeScreen home_screen = new HomeScreen(getDriver());

        this.login_screen = home_screen.clickOnLogin();
        this.test_email = DataGenerator.generateRandomEmail();
    }


    @Test(groups = {"SignUpTest"})
    public void signUpTest(){

        SignUpScreen sign_up_screen = this.login_screen.clickOnSignUp();
        boolean check_text = sign_up_screen.createUser(this.test_email,this.test_password);

        Assert.assertTrue(check_text,"The text does not display a success message");
    }



}
