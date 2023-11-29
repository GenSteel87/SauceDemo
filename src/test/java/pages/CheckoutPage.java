package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    private final By FIRST_NAME_INPUT = By.id("first-name");
    private final By LAST_NAME_INPUT = By.id("last-name");
    private final By ZIP_POSTAL_CODE_INPUT = By.id("postal-code");
    private final By CONTINUE_BUTTON = By.id("continue");
    private final By CANCEL_BUTTON = By.id("cancel");
    private final By FINISH_BUTTON = By.id("finish");
    private final By CHECKOUT_STATUS = By.className("title");
    private final By BACK_HOME_BUTTON = By.className("back-to-products");
    private final By ERROR_MESSAGE = By.cssSelector("h3");

    @Step("Fill in form")
    public void checkoutFillInForm(String firstName, String lastName, String zipPostalCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_POSTAL_CODE_INPUT).sendKeys(zipPostalCode);
        takeScreenshot(driver);
    }

    @Step("Click [Continue] button")
    public void goToTheSecondStep() {
        takeScreenshot(driver);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    @Step("Click [Finish] button")
    public void finishCheckout() {
        takeScreenshot(driver);
        driver.findElement(FINISH_BUTTON).click();
    }

    @Step("Click [Back Home] button")
    public void backHome() {
        takeScreenshot(driver);
        driver.findElement(BACK_HOME_BUTTON).click();
    }

    @Step("Check status")
    public String checkStatus() {
        takeScreenshot(driver);
        return(driver.findElement(CHECKOUT_STATUS).getText());
    }

    public String getErrorMessage() {
        return(driver.findElement(ERROR_MESSAGE).getText());
    }

    @Step("Click [Cancel] button")
    public  void goToPreviousStep() {
        takeScreenshot(driver);
        driver.findElement(CANCEL_BUTTON).click();
    }
}
