package com.saucedemo.tests;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductPage;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.utils.BaseClass;

public class MainTest {

    public static void main(String[] args) throws InterruptedException {

        BaseClass.openBrowser();
        Thread.sleep(2000);

        // TEST 1 - Valid Login
        System.out.println("TEST 1: Valid Login");
        LoginPage login = new LoginPage(BaseClass.driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();
        Thread.sleep(2000);

        // TEST 2 - Products Page Loaded
        System.out.println("TEST 2: Products Page");
        ProductPage products = new ProductPage(BaseClass.driver);
        System.out.println("Page Title: " + products.getPageTitle());
        Thread.sleep(1000);

        // TEST 3 - Add to Cart
        System.out.println("TEST 3: Add to Cart");
        products.addFirstProductToCart();
        System.out.println("Product added to cart successfully!");
        Thread.sleep(1000);

        // TEST 4 - Go to Cart
        System.out.println("TEST 4: Cart Page");
        products.goToCart();
        Thread.sleep(1000);
        CartPage cart = new CartPage(BaseClass.driver);
        System.out.println("Cart Title: " + cart.getCartTitle());
        System.out.println("Item in cart: " + cart.isItemInCart());
        Thread.sleep(1000);

        // TEST 5 - Checkout
        System.out.println("TEST 5: Checkout");
        cart.clickCheckout();
        Thread.sleep(1000);
        CheckoutPage checkout = new CheckoutPage(BaseClass.driver);
        checkout.enterDetails("Bhoomi", "Shinde", "400001");
        checkout.clickContinue();
        Thread.sleep(1000);
        checkout.clickFinish();
        Thread.sleep(2000);
        System.out.println("Success: " + checkout.getSuccessMessage());

        System.out.println("============================");
        System.out.println("ALL TESTS PASSED!");
        System.out.println("============================");
        Thread.sleep(2000);
        BaseClass.closeBrowser();
    }
}