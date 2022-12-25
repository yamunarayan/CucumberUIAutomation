package com.lao.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class VerifyPendingTS {
    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
       System.out.println("User is on the home page");
    }
    @Given("User clicks on the time option from menu")
    public void user_clicks_on_the_time_option_from_menu() {
        System.out.println("User clicks on the time option from menu");
    }
    @Given("User enters name as {string}")
    public void user_enters_name_as(String string) {
        System.out.println("User enters name as John Smith");
    }
    @Given("Clicks on the view button")
    public void clicks_on_the_view_button() {
        System.out.println("Clicks on the view button");
    }
    @Then("User should see the message as {string}")
    public void user_should_see_the_message_as(String string) {
        System.out.println("User should see the message as John Smith");
    }
}
