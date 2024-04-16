package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends TestBase {

    @FindBy(name = "username")
    WebElement uname;
    @FindBy(name = "password")
    WebElement pawd;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//img[contains(@class,'img-responsive')]")
    WebElement crmLogo;

    public LoginPage() throws IOException {

        PageFactory.initElements(driver, this);
    }

    public boolean validateCroImage()
    {
        return crmLogo.isDisplayed();
    }

    public HomePage Login(String un, String pwd)
    {
        uname.sendKeys(un);
        pawd.sendKeys(pwd);
        loginBtn.click();

        return new HomePage();


    }
}
