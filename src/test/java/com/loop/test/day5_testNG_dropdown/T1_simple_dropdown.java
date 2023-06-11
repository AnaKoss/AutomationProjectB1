package com.loop.test.day5_testNG_dropdown;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_simple_dropdown {

    //1. Open Chrome browse
    //2. Go to http://the-internet.herokuapp.com/dropdown
    //3. Verify “Dropdown list” default selected value is correct - Expected: “Please select an option”

    WebDriver driver;
    String expected ="Please select the options";
    String actual;


    @BeforeMethod
public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void dropdownTest(){
        driver.get("http://the-internet.herokuapp.com/dropdown");
        //create dropdown
// WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='dropdown']"));
// Select dropdown = new Select(dropdownElement);

        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));


        //give us what is already selected
        //return web element
        actual = dropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actual, expected, "does not match");
    }

}
