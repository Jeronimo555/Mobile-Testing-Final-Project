package com.globant.mobile.tests;

import com.globant.mobile.screens.HomeScreen;
import com.globant.mobile.screens.LoginScreen;
import com.globant.mobile.utils.DataGenerator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    private LoginScreen login_screen;

    @BeforeMethod(groups = {"LoginTest"})
    public void preconditions(){
        HomeScreen home_screen = new HomeScreen(getDriver());

        this.login_screen = home_screen.clickOnLogin();
        String test_email = DataGenerator.generateRandomEmail();
        String test_password = "SecurePassword123!";

        this.login_screen.clickOnSignUp();
        login_screen.createUser(test_email, test_password);

        login_screen.clickOnOkSucess();
        this.login_screen.clickOnLogin();
    }

    /**
     * Since the precondition includes the user creation, the Login form already has that data in the text field,
     * so we only need to click on the button to log in.
     */
    @Test(groups = {"LoginTest"})
    public void loginTest(){
        this.login_screen.clickOnLoginFormBtn();
        boolean check_text = this.login_screen.checkSuccessMsg();

        Assert.assertTrue(check_text,"The text does not display a success message");
    }
}
