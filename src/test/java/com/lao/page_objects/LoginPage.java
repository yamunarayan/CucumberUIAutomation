package com.lao.page_objects;

import com.lao.utilities.CommonUtils;
import com.lao.webdriver_manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public WebDriver driver= DriverManager.getDriver();
    private static LoginPage loginPage;
    private LoginPage(){
    }
    public static LoginPage getInstance(){
        if(loginPage==null){
            loginPage= new LoginPage();
        }
        return loginPage;
    }

    By USERNAME= By.name("username");
    By PASSWORD = By.name("password");
    By LOGIN= By.xpath("//button[@type='submit']");

/*
    @FindBy(name="password")
    private WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement loginButton;*/
    /*public WebElement getUsername() {
        return username;
    }
    public WebElement getPassword() {
        return password;
    }
    public WebElement getLoginButton() {
        return loginButton;
    }*/
    public void enterUserName(String  userName){
        try{
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
            driver.findElement(USERNAME).sendKeys(userName);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Element not available will search fro that using explicit wait");
            try{
               WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
               wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME));
            }catch(Exception e1){
                System.out.println("Element not available");
            }
        }

    }
    public void enterPassword(String passWord){
        driver.findElement(PASSWORD).sendKeys(passWord);
    }
    public void clickLogin(){
        CommonUtils.getInstance().highlightElement(driver.findElement(LOGIN));
        driver.findElement(LOGIN).click();
    }



}
