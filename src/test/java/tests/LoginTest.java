package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest{

    @Test(description = "Успешный логин")
    public void successfulLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(
                productsPage.getTitle(),
                "Products",
                "User is not logged in or wrong page");
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"test", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"standard_user", "test", "Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce", "Epic sadface: Username is required"}
        };
    }
    @Test(description = "негативные проверки логина", dataProvider = "loginData")
    public void negativeLogin(String user, String password, String expectedError) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(
                loginPage.getError(),
                expectedError,
                "Wrong error message is shown");
    }
}
