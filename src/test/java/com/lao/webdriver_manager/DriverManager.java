package com.lao.webdriver_manager;

import com.lao.constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DriverManager {
        public static WebDriver driver=null;
    private static final Logger LOGGER= LogManager.getLogger(DriverManager.class);

    public static void launchBrowser() {
        try{
            switch(Constants.BROWSER){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    LOGGER.info("Launching chrome browser");
                    driver= new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    LOGGER.info("Launching firefox browser");
                    driver= new FirefoxDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    LOGGER.info("Launching edge browser");
                    driver= new EdgeDriver();
                    break;
                default :
                    WebDriverManager.chromedriver().setup();
                    LOGGER.info("Launching chrome browser");
                    driver= new ChromeDriver();
                    break;

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static WebDriver getDriver() {
        return driver;
    }
}
