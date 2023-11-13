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
        driver.get(" https://www.saucedemo.com");
        driver.findElement(By.id("user-name"));
        driver.findElement(By.name("user-name"));
        driver.findElement(By.xpath("//input[@placeholder = 'Username']"));
        driver.findElement(By.tagName("[type = text]"));
        driver.findElement(By.id("login-button"));
        driver.findElement(By.cssSelector(".submit-button"));
        driver.findElement(By.className("submit-button"));
        driver.findElement(By.xpath("//input[contains(@class, 'submit')]"));
        driver.findElement(By.xpath("//input[contains(@class, 'submit')]"));


    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
