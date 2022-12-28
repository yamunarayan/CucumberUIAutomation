package com.lao.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimesheetPage {
    private static TimesheetPage timesheetPage;

    private TimesheetPage(){

    }
    public static TimesheetPage getInstance(){
        if(timesheetPage==null){
            timesheetPage= new TimesheetPage();
        }
        return timesheetPage;
    }
    @FindBy(xpath="//input[@placeholder='Type for hints...']")
    private WebElement employeeName;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement viewButton;

    @FindBy(xpath="(//div/h6)[2]")
    private WebElement timesheetmessage;

    public void enteremployeeName(){
        employeeName.sendKeys("John Smith");
    }
    public void clickView(){
        viewButton.click();
    }
    public String timesheetAction(){
      return timesheetmessage.getText();
    }

}
