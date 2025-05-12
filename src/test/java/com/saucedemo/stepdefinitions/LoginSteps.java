package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.ConfigReader;
import com.saucedemo.utils.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("I am on the SauceDemo login page")
    public void i_am_on_the_saucedemo_login_page() {
        driver.get(ConfigReader.getProperty("app.url"));
        driver.manage().window().maximize();
//        throw new io.cucumber.java.PendingException();
    }

    @When("I enter a valid username and password")
    public void i_enter_a_valid_username_and_password() {
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
//        loginPage.clickLogin();
//        throw new io.cucumber.java.PendingException();
    }
    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLogin();
//        throw new io.cucumber.java.PendingException();
    }

    @Then("I should be redirected to the Products page")
    public void i_should_be_redirected_to_the_products_page() {
        String expectedTitle = "Swag Labs"; // Adjust this if necessary based on actual title
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
//        throw new io.cucumber.java.PendingException();
    }

    @Then("I should see the product list")
    public void i_should_see_the_product_list() {
        // Assuming there's a method to verify the product list is displayed, for example, checking an element
        // You would add your verification code here
        // Assert.assertTrue(productsPage.isProductListVisible());
//        throw new io.cucumber.java.PendingException();
    }

    @When("I enter an invalid username or password")
    public void i_enter_an_invalid_username_or_password() {
        // Use invalid credentials, here hardcoded for illustration
        loginPage.enterUsername("invalid_user");
        loginPage.enterPassword("invalid_password");
        loginPage.clickLogin();
//        throw new io.cucumber.java.PendingException();
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedErrorMessage) {
        // Assuming you have a method to get the error message from the page
        String actualErrorMessage = loginPage.getErrorMessage(); // You would need to implement this in LoginPage
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
//        throw new io.cucumber.java.PendingException();
    }
}
