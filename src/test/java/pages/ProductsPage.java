package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector(".title");
    private final String ADD_TO_CHART_PATTERN = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    private final By CHART = By.id("shopping_cart_container");
    private final String REMOVE_FROM_CHART_PATTERN = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    private final By SHOPPING_CART_BADGE = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return driver.findElement(TITLE).getText();
    }

    public void openChart() {
        driver.findElement(CHART).click();
    }

    public void addToChart(String product) {
        By addToChartButton = By.xpath(String.format(ADD_TO_CHART_PATTERN, product));
        driver.findElement(addToChartButton).click();
    }
    public void removeFromChart(String product) {
        By removeFromChartButton = By.xpath(String.format(REMOVE_FROM_CHART_PATTERN, product));
        driver.findElement(removeFromChartButton).click();
    }
    public String getCountOfProducts() {
        return(driver.findElement(SHOPPING_CART_BADGE).getText());
    }

}
