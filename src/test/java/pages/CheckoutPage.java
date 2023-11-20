package pages;

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
    private final By ERROR_MESSAGE = By.xpath("//*[text()='Error: First Name is required']");

    public void checkoutFillInForm(String firstName, String lastName, String zipPostalCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_POSTAL_CODE_INPUT).sendKeys(zipPostalCode);
    }
    public void goToTheSecondStep() {
        driver.findElement(CONTINUE_BUTTON).click();
    }
    public void finishCheckout() {
        driver.findElement(FINISH_BUTTON).click();
    }
    public void backHome() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }
    public String checkStatus() {
        return(driver.findElement(CHECKOUT_STATUS).getText());
    }
    public String getErrorMessage() {
        return(driver.findElement(ERROR_MESSAGE).getText());
    }
}
