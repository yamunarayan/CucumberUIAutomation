package com.lao.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    private static HomePage homePage;
    private HomePage(){

    }
    public static HomePage getInstance(){
        if(homePage==null){
            homePage= new HomePage();
        }
        return homePage;
    }
 /*   public WebElement getDirectoryElement() {
        return directoryElement;
    }*/
    @FindBy(partialLinkText = "Directory")
    private WebElement directoryElement;

    @FindBy(partialLinkText = "Time")
    private WebElement TimeElement;

    public void directorLink(){
        directoryElement.click();
    }

    public void timeLink(){
        TimeElement.click();
    }
}
