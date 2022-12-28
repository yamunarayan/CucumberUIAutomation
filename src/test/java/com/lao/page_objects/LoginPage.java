package com.lao.page_objects;

import com.lao.utilities.CommonUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    private static LoginPage loginPage;
    private LoginPage(){
    }
    public static LoginPage getInstance(){
        if(loginPage==null){
            loginPage= new LoginPage();
        }
        return loginPage;
    }

    @FindBy(name="username")
    private WebElement username;

    @FindBy(name="password")
    private WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement loginButton;
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
        username.sendKeys(userName);
    }
    public void enterPassword(String passWord){
        password.sendKeys(passWord);
    }
    public void clickLogin(){
        CommonUtils.getInstance().highlightElement(loginButton);
        loginButton.click();
    }



}
