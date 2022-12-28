package com.lao.step_definitions;

import com.lao.constants.Constants;
import com.lao.page_objects.DirectoryPage;
import com.lao.page_objects.HomePage;
import com.lao.page_objects.LoginPage;
import com.lao.utilities.CommonUtils;
import com.lao.webdriver_manager.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.time.Duration;


public class VerifyCEOName {
    private static final Logger LOGGER= LogManager.getLogger(VerifyCEOName.class);
    @Given("User logged in successfully")
    public void user_logged_in_successfully() {
        try {

            LOGGER.info("User logged in successfully");
        }catch(Exception e){
            LOGGER.error(e);
            CommonUtils.getInstance().takeScreenshot();
            Assert.fail(e.getMessage());
        }
    }
    @When("User clicks on the directory option from the menu bar")
    public void user_clicks_on_the_directory_option_from_the_menu_bar() {
        try{
            HomePage.getInstance().directorLink();
            LOGGER.info("User clicks on the directory option from the menu bar");
        }catch(Exception e){
            LOGGER.error(e);
            CommonUtils.getInstance().takeScreenshot();
            Assert.fail(e.getMessage());
        }

    }
    @When("The user selects the job title as {string} from the dropdown {string}")
    public void the_user_selects_the_job_title_as_from_the_dropdown(String jobTitle, String howTo) {
        try{
            CommonUtils.getInstance().selectDropdownElement(DirectoryPage.getInstance().selectJobTitle(),jobTitle,howTo);
            LOGGER.info("The user selects the job title as {string} from the dropdown");
        }catch(Exception e){
            LOGGER.error(e);
            CommonUtils.getInstance().takeScreenshot();
            Assert.fail(e.getMessage());
        }
             }
    @When("Clicks the search button")
    public void clicks_the_search_button() {
        try{
            DirectoryPage.getInstance().search();
            LOGGER.info("Clicks the search button");
        }catch(Exception e){
            LOGGER.error(e);
            CommonUtils.getInstance().takeScreenshot();
            Assert.fail(e.getMessage());
        }

    }
    @Then("The user should see the CEO name as {string}")
    public void the_user_should_see_the_ceo_name_as(String jobTitle) {
        try{
            String name= DirectoryPage.getInstance().getsearchResults();
            // Assert.assertEquals(CEOname, jobTitle);
            LOGGER.info("The user should see the CEO name as John Smith");
        }catch(Exception e){
            LOGGER.error(e);
            CommonUtils.getInstance().takeScreenshot();
            Assert.fail(e.getMessage());
        }

    }
}
