package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest{

    @Test
    public void successfulLogin (){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(
                productsPage.getTitle(),
                "Products",
                "User is not logged in or wrong page");
    }
    @Test
    public void invalidEmailLogin (){
        loginPage.open();
        loginPage.login("test", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void invalidPasswordLogin (){
        loginPage.open();
        loginPage.login("standard_user", "test");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void emptyLogin (){
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service");
    }
}
