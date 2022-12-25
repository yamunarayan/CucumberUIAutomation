package com.lao.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DirectoryPage {

    @FindBy(xpath="//i[@class='oxd-icon bi-caret-up-fill']")
    public static WebElement directorydropdown;

    @FindBy(xpath="(//div[@class='oxd-select-wrapper']/div/div)[1]")
    public static WebElement jobTitle;
}
