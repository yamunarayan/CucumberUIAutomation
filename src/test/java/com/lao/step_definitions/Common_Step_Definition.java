package com.lao.step_definitions;

import com.lao.constants.Constants;
import com.lao.page_objects.DirectoryPage;
import com.lao.page_objects.HomePage;
import com.lao.page_objects.LoginPage;
import com.lao.utilities.CommonUtils;
import com.lao.webdriver_manager.DriverManager;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;




public class Common_Step_Definition {
     private static  final Logger LOGGER = LogManager.getLogger(Common_Step_Definition.class);
     private static String scenarioName=null;

     public static String getScenarioName(){
         return scenarioName;
     }


    @Before
    public void beforeScenario(Scenario scenario){

        try{
            scenarioName=scenario.getName();
            CommonUtils.getInstance().loadProperties();
            LOGGER.info("Checking driver is null or not");
            if(DriverManager.getDriver()==null){

                DriverManager.launchBrowser();
                CommonUtils.getInstance().initElements();
                login();
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private void login() {
        DriverManager.getDriver().get(Constants.APP_URL);
       // DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        LoginPage.getInstance().enterUserName(Constants.Username);
        LoginPage.getInstance().enterPassword(Constants.Password);
        LoginPage.getInstance().clickLogin();
    }
@AfterStep
    public void takeScreenshot(Scenario scenario){
         if(scenario.isFailed()){
             byte[] screenshotTaken = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
             scenario.attach(screenshotTaken,"image/png", "screenshot");
         }

    }

}
