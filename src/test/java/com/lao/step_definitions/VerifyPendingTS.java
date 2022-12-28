package com.lao.step_definitions;

import com.lao.constants.Constants;
import com.lao.page_objects.HomePage;
import com.lao.page_objects.LoginPage;
import com.lao.page_objects.TimesheetPage;
import com.lao.utilities.CommonUtils;
import com.lao.webdriver_manager.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;


import java.time.Duration;

public class VerifyPendingTS {
    private static final Logger LOGGER= LogManager.getLogger(VerifyPendingTS.class);
    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        try{

        }catch(Exception e){
            LOGGER.error(e);
            CommonUtils.getInstance().takeScreenshot();
            Assert.fail(e.getMessage());
        }
       String url = DriverManager.getDriver().getCurrentUrl();
       if(url.contains("dashboard")){
           LOGGER.info("User is on the home page");
       }

    }
    @Given("User clicks on the time option from menu")
    public void user_clicks_on_the_time_option_from_menu() {
        try{
            HomePage.getInstance().timeLink();
            LOGGER.info("User clicks on the time option from menu");
        }catch(Exception e){
            LOGGER.error(e);
            CommonUtils.getInstance().takeScreenshot();
            Assert.fail(e.getMessage());
        }
           }
    @Given("User enters name as {string}")
    public void user_enters_name_as(String string) {
        try{
            TimesheetPage.getInstance().enteremployeeName();
            LOGGER.info("User enters name as John Smith");
        }catch(Exception e){
            LOGGER.error(e);
            CommonUtils.getInstance().takeScreenshot();
            Assert.fail(e.getMessage());
        }

    }
    @Given("Clicks on the view button")
    public void clicks_on_the_view_button() {
        try{
            TimesheetPage.getInstance().clickView();
            LOGGER.info("Clicks on the view button");
        }catch(Exception e){
            LOGGER.error(e);
            CommonUtils.getInstance().takeScreenshot();
            Assert.fail(e.getMessage());
        }

    }
    @Then("User should see the message as {string}")
    public void user_should_see_the_message_as(String message) {
        try{
            String text = TimesheetPage.getInstance().timesheetAction();
            Assert.assertEquals(text,message);
            LOGGER.info("User should see the message as John Smith");
        }catch(Exception e){
            LOGGER.error(e);
            CommonUtils.getInstance().takeScreenshot();
            Assert.fail(e.getMessage());
        }

    }
}
