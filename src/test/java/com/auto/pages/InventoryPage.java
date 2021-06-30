package com.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {

    private WebDriver driver;
    private List<WebElement> addToCartBtn;

    public InventoryPage(WebDriver driver){
        this.driver = driver;
        this.addToCartBtn = driver.findElements(By.className("btn_inventory"));
    }

    public List<WebElement> getAddToCartBtn(){
        return addToCartBtn;
    }
}
