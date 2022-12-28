package com.lao.utilities;
import com.lao.constants.Constants;
import com.lao.page_objects.DirectoryPage;
import com.lao.page_objects.HomePage;
import com.lao.page_objects.LoginPage;
import com.lao.page_objects.TimesheetPage;
import com.lao.step_definitions.Common_Step_Definition;
import com.lao.webdriver_manager.DriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CommonUtils {
    private static final Logger LOGGER= LogManager.getLogger(CommonUtils.class);
    private static CommonUtils commonUtils;
    private CommonUtils(){

    }
    public static CommonUtils getInstance(){
        if(commonUtils==null){
            commonUtils= new CommonUtils();
        }
        return commonUtils;
    }
    public void loadProperties() {

        Properties properties= new Properties();
       try {
           properties.load(getClass().getResourceAsStream("/config.properties"));
       }catch(Exception e){
           e.printStackTrace();
       }

       Constants.APP_URL=properties.getProperty("APP_URL");
       Constants.BROWSER=properties.getProperty("Browser");
       Constants.Username=properties.getProperty("Username");
       Constants.Password=properties.getProperty("Password");

    }
    public void initElements(){
        PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
        PageFactory.initElements(DriverManager.getDriver(), HomePage.getInstance());
        PageFactory.initElements(DriverManager.getDriver(), DirectoryPage.getInstance());
        PageFactory.initElements(DriverManager.getDriver(), TimesheetPage.getInstance());
    }
    public void takeScreenshot() {
        File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(Common_Step_Definition.getScenarioName()+"screenshot.png"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void highlightElement(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].setAttribute('style','border:3px solid blue');",element);
    }

    public void selectDropdownElement(WebElement element, String jobTitle,String howTo){
        Select select = new Select(element);
        switch (howTo){
            case "index":
                select.selectByIndex(Integer.parseInt(jobTitle));
                break;
            case "value":
                select.selectByValue(jobTitle);
                break;
            case "text":
                select.selectByVisibleText(jobTitle);
                break;
            default:
                LOGGER.info("Passing incorrect option; select either index,value or text");
                break;
        }
    }
}
