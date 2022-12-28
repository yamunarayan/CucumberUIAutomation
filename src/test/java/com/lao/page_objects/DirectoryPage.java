package com.lao.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DirectoryPage {
    private static DirectoryPage directoryPage;
    private DirectoryPage(){
    }
    public static DirectoryPage getInstance(){
        if(directoryPage==null){
            directoryPage=  new DirectoryPage();
        }
        return directoryPage;
    }

    @FindBy(xpath="(//div[@class='oxd-select-text-input'])[1]")
    private WebElement jobTitle;
    @FindBy(xpath="//button[@type='submit']")
    private WebElement searchButton;
    @FindBy(xpath="(//p[1])[2]")
    private WebElement searchResults;

    public WebElement selectJobTitle(){
        return jobTitle;

    }
    public void search(){
        searchButton.click();
    }
    public String  getsearchResults(){
        return searchResults.getText();
    }


   /* public WebElement getDirectorydropdown() {
        return directorydropdown;
    }

    public WebElement getJobTitle() {
        return jobTitle;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchResults() {
        return searchResults;
    }
*/

}
