package tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProductsTest extends BaseTest {

    @BeforeMethod
    public void comeMethod() {

    }

    @Test(description = "Пользователь может купить продукт")
    public void buyProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToChart("Sauce Labs Bike Light");
        productsPage.openChart();
        String productName = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
        String productPrice = driver.findElement(By.cssSelector(".inventory_item_price")).getText();

        assertEquals(
                productName,
                "Sauce Labs Bike Light",
                "Wrong product name in the cart");
        assertEquals(
                productPrice,
                "$9.99",
                "Wrong product price in the cart");
    }

    @Test(description = "Пользователь может удалить продукт из карзины")
    public void removeProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToChart("Sauce Labs Bike Light");
        productsPage.openChart();
        String productName = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
        assertEquals(
                productName,
                "Sauce Labs Bike Light",
                "Wrong product name in the cart");
        cartPage.continueShopping();
        productsPage.removeFromChart("Sauce Labs Bike Light");
        productsPage.openChart();
        assertNotSame(
                productName,
                "Sauce Labs Bike Light",
                "Product wasn't removed from chart");
    }

    @Test(description = "Бейдж колличества продуктов добавленных в корзину")
    public void countOfProducts() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToChart("Sauce Labs Bike Light");
        productsPage.addToChart("Sauce Labs Bolt T-Shirt");
        assertEquals(
                productsPage.getCountOfProducts(),
                "2",
                "Wrong products count");
    }

}
