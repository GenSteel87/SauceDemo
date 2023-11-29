package pages;

import io.qameta.allure.Step;
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

    @Step("Open Products page")
    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    @Step("Check title")
    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return driver.findElement(TITLE).getText();
    }

    @Step("Open chart")
    public void openChart() {
        driver.findElement(CHART).click();
    }

    @Step("Add product to chart")
    public void addToChart(String product) {
        By addToChartButton = By.xpath(String.format(ADD_TO_CHART_PATTERN, product));
        takeScreenshot(driver);
        driver.findElement(addToChartButton).click();
    }

    @Step("Remove product from chart")
    public void removeFromChart(String product) {
        By removeFromChartButton = By.xpath(String.format(REMOVE_FROM_CHART_PATTERN, product));
        takeScreenshot(driver);
        driver.findElement(removeFromChartButton).click();
    }

    @Step("Check count of products in chart")
    public String getCountOfProducts() {
        takeScreenshot(driver);
        return(driver.findElement(SHOPPING_CART_BADGE).getText());
    }

}
