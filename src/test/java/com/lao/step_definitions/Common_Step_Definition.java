package com.lao.step_definitions;

import com.lao.constants.Constants;
import com.lao.utilities.CommonUtils;
import com.lao.webdriver_manager.DriverManager;
import io.cucumber.java.Before;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;


public class Common_Step_Definition {
     private static  final Logger LOGGER = LogManager.getLogger(Common_Step_Definition.class);


    @Before
    public void beforeScenario(){

        try{
            CommonUtils commonUtils = new CommonUtils();
            commonUtils.loadProperties();
            LOGGER.info("Checking driver is null or not");
            if(DriverManager.getDriver()==null){

                DriverManager.launchBrowser();
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}
