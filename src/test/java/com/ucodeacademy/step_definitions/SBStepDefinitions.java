package com.ucodeacademy.step_definitions;

import com.ucodeacademy.pages.SBLoginPage;
import com.ucodeacademy.utilities.ConfigReader;
import com.ucodeacademy.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SBStepDefinitions {

    SBLoginPage loginPage = new SBLoginPage();

    @Given("User is on smart bear login page")
    public void user_is_on_smart_bear_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("smart"));
    }

    @When("User enter username and password")
    public void user_enter_username_and_password() {

        loginPage.usernameInput.sendKeys("Tester");
        loginPage.passwordInput.sendKeys("test");

    }
    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.loginButton.click();

    }
    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle ="Web Orders";

        Assert.assertEquals("Title does not match",expectedTitle, actualTitle);

        Driver.quitDriver();

    }

}
