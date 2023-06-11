package com.loop.test.home_tasks.task5;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Task_4 {
    WebDriver driver;


    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://app.docuport.app/company-formation/resident");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //What type of business do you want to start? - choose corporation
    @Test
    public void docuportTest(){

    //isSelected()
        List radioButtons = driver.findElements(By.name(""));
        boolean bval = false;
        //bval = radioButtons.get(2).isSelected();




    }
}
