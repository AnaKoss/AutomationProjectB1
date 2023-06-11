package com.loop.test.home_tasks.task5;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Task_1_1 {
    WebDriver driver;
    String actual;
    String expected;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void selectOption() {

        //validate "Please select an option" is selected by default

        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        actual = dropdown.getFirstSelectedOption().getText();
        expected = "Please select an option";

        assertEquals(actual,expected,"no matching detected");

        //Choose option 1 and validate that it is selected
        dropdown.selectByIndex(1);
        assertEquals(dropdown.getFirstSelectedOption().getText(),"Option 1");
        dropdown.selectByValue("1");
        assertEquals(dropdown.getFirstSelectedOption().getText(),"Option 1");
        dropdown.selectByVisibleText("Option 1");
        assertEquals(dropdown.getFirstSelectedOption().getText(),"Option 1");

        //Choose the option 2 and validate that it is selected
        dropdown.selectByIndex(2);
        assertEquals(dropdown.getFirstSelectedOption().getText(),"Option 2");
        dropdown.selectByValue("2");
        assertEquals(dropdown.getFirstSelectedOption().getText(),"Option 2");
        dropdown.selectByVisibleText("Option 2");
        assertEquals(dropdown.getFirstSelectedOption().getText(),"Option 2");


        //Validate dropdown name is "Dropdown List"

        WebElement dropdownListName = driver.findElement(By.xpath("//div/h3[text()='Dropdown List']"));
        expected ="Dropdown List";
        assertEquals(dropdownListName, "Dropdown List", dropdownListName + " Does NOT natch" + expected);
        driver.quit();
    }
}
