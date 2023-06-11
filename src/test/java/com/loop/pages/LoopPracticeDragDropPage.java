package com.loop.pages;

import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoopPracticeDragDropPage {
    //new way to identify element

    //WebElement element = Driver.getDriver().findElement(By.id()); --the same thing
    @FindBy(id="draggable")
    public WebElement smallCircle;

    @FindBy(id="droptarget")
    public WebElement bigCircle;


    public LoopPracticeDragDropPage (){ //created constractor

        PageFactory.initElements(Driver.getDriver(),this);
    }



}
