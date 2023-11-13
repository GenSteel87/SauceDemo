import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LocatorTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void findElements() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.cssSelector("[class~='login_logo']")).click();
        driver.findElement(By.cssSelector("[class='login_logo']")).click();
        driver.get(" https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.name("user-name")).click();
        driver.findElement(By.cssSelector(".submit-button")).click();
        driver.findElement(By.className("submit-button")).click();
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//input[@placeholder = 'Username']")).click();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[contains(@class, 'submit')]")).click();
        driver.findElement(By.xpath("//*[text()='Sauce Labs Bolt T-Shirt']//ancestor::div[@class='inventory_item_description']//div[@class='inventory_item_price']")).click();
        driver.findElement(By.xpath("//div[@id='shopping_cart_container' and @class='shopping_cart_container']")).click();






    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
