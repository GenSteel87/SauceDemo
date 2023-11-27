package pages;

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
    }
    public boolean checkoutIsDisplayed() {
        return driver.findElement(CHECK_OUT_BUTTON).isDisplayed();
    }
    public boolean isProductInTheCart (String product) {
        return driver.findElement(By.xpath(String.format("//div[@class='cart_item']//*[text()='%s']",product)))
                .isDisplayed();
    }
    public String getProductFromCart(int index) {
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

    public String getProductPrice(String product) {
        return driver.findElement(By.xpath("")).getText();
    }
    public void checkout() {
        driver.findElement(CHECK_OUT_BUTTON).click();
    }
    public void continueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

}
