import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest{

    @Test
    public void successfulLogin (){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String title = driver.findElement(By.cssSelector(".title")).getText();

        assertEquals(title, "Products", "User is not logged in or wrong page");
    }
    @Test
    public void invalidEmailLogin (){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("invalid_user_name");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String errorMessage = driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText();

        assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void invalidPasswordLogin (){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("invalid_password");
        driver.findElement(By.id("login-button")).click();
        String errorMessage = driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText();

        assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void emptyLogin (){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("login-button")).click();
        String errorMessage = driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText();

        assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }
}
