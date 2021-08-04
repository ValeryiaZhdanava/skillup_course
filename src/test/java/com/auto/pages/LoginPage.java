package com.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

   private WebDriver driver;
   private WebElement loginButton;
   private WebElement usernameField;
   private WebElement passwordField;
   private final static String errorXpath = "//h3[@data-test = 'error']";
   private final static String loginBtnXpath = "//div[@class='login-box']//input[@data-test = 'login-button']";




    public LoginPage(WebDriver driver) {
        this.driver = driver;
        loginButton = driver.findElement(By.xpath(loginBtnXpath));
        usernameField = driver.findElement(By.id("user-name"));
        passwordField = driver.findElement(By.id("password"));
    }

    public void fillUsername(String text){
        usernameField.sendKeys(text);
    }


    public void fillPassword(String text){
        passwordField.sendKeys(text);
    }

    public void clickLoginBtn(){
        loginButton.click();
    }

    public WebElement getLoginError(){
        return driver.findElement(By.xpath(errorXpath));
    }

    public WebElement getErrorButton() {
        return driver.findElement(By.className("error-button"));
    }

    public String getFirstValue(String className){
        String values = driver.findElement(By.className(className)).getText();
        return values.split("\n")[1];
    }
}
