package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
    @DataProvider
    public Object[][] userInformation() {
        return new Object[][]{
                {"", "Test_last_name", "12345", "Error: First Name is required"},
                {"Test_first_name", "", "12345", "Error: Last Name is required"},
                {"Test_first_name", "Test_last_name", "", "Error: Postal Code is required"}
        };
    }
    @Test(description = "Проверка формы оформления заказа", dataProvider = "userInformation")
    public void checkoutFormValidation(String firstName, String lastName, String zipCode, String errorMessage) {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToChart("Sauce Labs Bike Light");
        productsPage.openChart();
        cartPage.checkout();
        checkoutPage.checkoutFillInForm(firstName, lastName, zipCode);
        checkoutPage.goToTheSecondStep();
        assertEquals(
                checkoutPage.getErrorMessage(),
                errorMessage,
                "Error message should be displayed");

    }
    @Test(description = "При оформлении заказа пользователь может вернуться на предыдущий шаг")
    public void goToPreviousStep() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToChart("Sauce Labs Bike Light");
        productsPage.openChart();
        cartPage.checkout();
        checkoutPage.goToPreviousStep();

        assertTrue(
                cartPage.checkoutIsDisplayed(), "Checkout is not displayed");
        cartPage.checkout();
        checkoutPage.checkoutFillInForm("Test_first_name", "Test_last_name", "12345");
        checkoutPage.goToTheSecondStep();
        checkoutPage.goToPreviousStep();

        assertEquals(
                productsPage.getTitle(),
                "Products",
                "Products page is not displayed");
    }
}
