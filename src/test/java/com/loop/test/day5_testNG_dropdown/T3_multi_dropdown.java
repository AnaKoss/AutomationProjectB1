package com.loop.test.day5_testNG_dropdown;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class T3_multi_dropdown {
/*
    1. Open Chrome browser
    2. Go to https://demoqa.com/select-menu
    3. Select all the options from multiple select dropdown.
    4. Print out all selected values.
    5. Deselect all values.
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterMethod
    public void tearDownMethod(){
        //driver.close();

    }

    @Test
    public void multiSelectTest(){
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='cars']")));
        //if this dropdown allows multiple selection
        Assert.assertTrue(dropdown.isMultiple());

//one by one selection

//        //select by index
//        dropdown.selectByIndex(0);
//
//        //select by value
//        dropdown.selectByValue("saab");
//        //select by text
//        dropdown.selectByVisibleText("Opel");
//
//        //select by index
//        dropdown.selectByIndex(2);


        //all together selection

        List<WebElement> options = new ArrayList<>();
        options = dropdown.getOptions();
        options.forEach(option-> {
            option.click();
            System.out.println("option: " + option.getText());
        });

        System.out.println("____________________________");
        for (WebElement option : options) {
            System.out.println("option: " + option.getText());
        }

        //deselect all values
        dropdown.deselectAll();

//how to validate that everything is deselected

       // System.out.println("selected option: " + dropdown.getFirstSelectedOption().getText());

    }

}
