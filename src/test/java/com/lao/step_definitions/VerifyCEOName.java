package com.lao.step_definitions;

import com.lao.constants.Constants;
import com.lao.page_objects.HomePage;
import com.lao.page_objects.LoginPage;
import com.lao.webdriver_manager.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class VerifyCEOName {
    private static final Logger LOGGER= LogManager.getLogger(VerifyCEOName.class);
    @Given("User logged in successfully")
    public void user_logged_in_successfully() {
        DriverManager.getDriver().get(Constants.APP_URL);
        LoginPage.username.sendKeys(Constants.Username);
        LoginPage.password.sendKeys(Constants.Password);
        LoginPage.loginButton.click();
        LOGGER.info("User logged in successfully");
    }
    @When("User clicks on the directory option from the menu bar")
    public void user_clicks_on_the_directory_option_from_the_menu_bar() {
        HomePage.directoryElement.click();
        System.out.println("User clicks on the directory option from the menu bar");
    }
    @When("The user selects the job title as {string} from the dropdown")
    public void the_user_selects_the_job_title_as_from_the_dropdown(String string) {
        System.out.println("The user selects the job title as {string} from the dropdown");
    }
    @When("Clicks the search button")
    public void clicks_the_search_button() {
        System.out.println("Clicks the search button");
    }
    @Then("The user should see the CEO name as {string}")
    public void the_user_should_see_the_ceo_name_as(String string) {
        System.out.println("The user should see the CEO name as John Smith");
    }
}
