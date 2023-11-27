package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test(description = "Пользователь может успешно оформить заказ")
    public void successfulCheckout() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToChart("Sauce Labs Bike Light");
        productsPage.openChart();
        cartPage.checkout();
        checkoutPage.checkoutFillInForm("Test", "Test", "12345");
        assertEquals(
                checkoutPage.checkStatus(),
                "Checkout: Your Information",
                "Wrong status");
        checkoutPage.goToTheSecondStep();
        assertEquals(
                checkoutPage.checkStatus(),
                "Checkout: Overview",
                "Wrong status");
        checkoutPage.finishCheckout();
        assertEquals(
                checkoutPage.checkStatus(),
                "Checkout: Complete!",
                "Wrong status");

    }
    @Test(description = "Проверка формы оформления заказа")
    public void checkoutFormValidation() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToChart("Sauce Labs Bike Light");
        productsPage.openChart();
        cartPage.checkout();
        checkoutPage.checkoutFillInForm("", "Test", "12345");
        checkoutPage.goToTheSecondStep();
        assertEquals(
                checkoutPage.getErrorMessage(),
                "Error: First Name is required",
                "Error message should be displayed");

    }
}
