package com.qa.test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage  homepage;

    public LoginPageTest() throws IOException {
        super();
    }

    @BeforeMethod()
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginTest() {
       homepage= loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
    }


    @AfterMethod()
    public void teardown() {
        driver.quit();
    }
}
