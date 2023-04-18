package testsuit;
/**
 * 2. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * <p>
 * 1. LoginTest
 * <p>
 * 3. Write down the following test into ‘LoginTest’ class
 * <p>
 * 1. userSholdLoginSuccessfullyWithValid
 * <p>
 * Credentials
 * Enter “standard_user” username
 * Enter “secret_sauce” password
 * Click on ‘LOGIN’ button
 * Verify the text “PRODUCTS”
 * <p>
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * <p>
 * Enter “standard_user” username
 * Enter “secret_sauce” password
 * Click on ‘LOGIN’ button
 * <p>
 * Verify that six products are displayed
 * on page
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find Username field element
        WebElement usernameField = driver.findElement(By.id("user-name"));
        // Type the UserName in username field element
        usernameField.sendKeys("standard_user");
        //Find the Password Field Element and send password on password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("secret_sauce");
        //Find the Login btn Element and click
        WebElement loginbutton = driver.findElement(By.id("login-button"));
        loginbutton.click();
        String expectedMassage = "Products";
        WebElement actualMassage = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String actualMessage = actualMassage.getText();
        Assert.assertEquals(expectedMassage, actualMessage);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //find Username field element
        WebElement usernameField = driver.findElement(By.id("user-name"));
        // Type the UserName in username field element
        usernameField.sendKeys("standard_user");
        //Find the Password Field Element and send password on password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("secret_sauce");
        //Find the Login btn Element and click
        WebElement loginbutton = driver.findElement(By.id("login-button"));
        loginbutton.click();
        List<WebElement> number = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualnumber = number.size();
        int expectednumber = 6;
        Assert.assertEquals("6 product not displayed", expectednumber, actualnumber);

    }

    @After
    public void close() {
        driver.close();
    }


}