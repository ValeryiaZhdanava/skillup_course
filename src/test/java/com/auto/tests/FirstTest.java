package com.auto.tests;


import com.auto.pages.InventoryPage;
import com.auto.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.logging.Logger;


public class FirstTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest(){
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginBtn();
        softAssert.assertEquals(loginPage.getLoginError().getText(), "Epic sadface: Username is required", "Error text is not correct.");
        loginPage.getErrorButton().click();

        String username = loginPage.getFirstValue("login_credentials");
        String password = loginPage.getFirstValue("login_password");
        loginPage.fillUsername(username);
        loginPage.fillPassword(password);
        loginPage.clickLoginBtn();

        InventoryPage inventoryPage = new InventoryPage(driver);
        int numOfBtn = inventoryPage.getAddToCartBtn().size();
        Assert.assertTrue(numOfBtn > 0, "The inventory page was not opened");
        softAssert.assertAll();
        System.out.println("Test is finished. Login was successful!!!");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
