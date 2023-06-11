package com.loop.home_pages;

import com.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoopAcademyPracticeDragDropHome {

    @FindBy (id="column-a")
    public WebElement boxA;

    @FindBy (id = "column-b")
    public WebElement boxB;


    public LoopAcademyPracticeDragDropHome(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
