package com.lao.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(partialLinkText = "Directory")
    public static WebElement directoryElement;
}
