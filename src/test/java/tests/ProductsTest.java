package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test
    public void buyProduct() {
        loginPage.open();
        loginPage.login("", "");
        productsPage.addToChart("Sauce Labs Bike Light");
        productsPage.openChart();
        String productName = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
        String productPrice = driver.findElement(By.cssSelector(".inventory_item_price")).getText();

        assertEquals(productName, "Sauce Labs Bike Light", "Wrong product name in the cart");
        assertEquals(productPrice, "$9.99", "Wrong product price in the cart");
    }
}
