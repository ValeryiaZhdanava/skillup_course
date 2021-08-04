package com.auto.tests;


import com.auto.helpers.BaseTest;
import com.auto.pages.InventoryPage;
import com.auto.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NegativeTest extends BaseTest {

    @Test
    public void negativeLoginTest(){
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginBtn();
        softAssert.assertEquals(loginPage.getLoginError().getText(), "Epic sadface: Username is required", "Error text is not correct.");
        loginPage.getErrorButton().click();

        softAssert.assertAll();
        System.out.println("Test is finished.");
    }

}
