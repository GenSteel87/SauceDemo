package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    private final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    private final By CHECK_OUT_BUTTON = By.id("checkout");
    public void isOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("checkout")));
        takeScreenshot(driver);
    }
    public boolean checkoutIsDisplayed() {
        takeScreenshot(driver);
        return driver.findElement(CHECK_OUT_BUTTON).isDisplayed();
    }
    public boolean isProductInTheCart (String product) {
        takeScreenshot(driver);
        return driver.findElement(By.xpath(String.format("//div[@class='cart_item']//*[text()='%s']",product)))
                .isDisplayed();
    }

    @Step("Check product name")
    public String getProductFromCart(int index) {
        takeScreenshot(driver);
        return driver.findElements(By.cssSelector(".inventory_item_name"))
                .get(index)
                .getText();
    }
    public ArrayList<String> getProductsNames() {
        List<WebElement> allProdutsElements = driver.findElements(By.cssSelector(".inventory_item_name"));
        ArrayList<String> names = new ArrayList<>();
        for(WebElement product:allProdutsElements){
            product.getText();
        }
        return names;
    }
    @Step("Check product price")
    public String getProductPrice(String product) {
        takeScreenshot(driver);
        return driver.findElement(By.xpath("")).getText();
    }

    @Step("Click [Checkout] button")
    public void checkout() {
        takeScreenshot(driver);
        driver.findElement(CHECK_OUT_BUTTON).click();
    }

    @Step("Click [Continue Shopping] button")
    public void continueShopping() {
        takeScreenshot(driver);
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

}
