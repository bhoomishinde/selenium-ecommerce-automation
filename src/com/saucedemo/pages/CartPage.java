package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    By cartTitle      = By.cssSelector(".title");
    By checkoutButton = By.id("checkout");
    By cartItem       = By.cssSelector(".cart_item");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartTitle() {
        return driver.findElement(cartTitle).getText();
    }

    public boolean isItemInCart() {
        return driver.findElements(cartItem).size() > 0;
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}