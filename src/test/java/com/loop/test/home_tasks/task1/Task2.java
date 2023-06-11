package com.loop.test.home_tasks.task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    /*
    1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon | Etsy”
     */
    public static void main(String[] args) {

        // set up the driver
        WebDriverManager.chromedriver().setup();

        // create driver object
        WebDriver driver = new ChromeDriver();

        // navigate to google page
        driver.get("https://www.etsy.com/?ref=lgo");

        // maximize the window
        driver.manage().window().maximize();

        //HOW TO SEARCH THE TEXT in 2 WAYS!!!
        //WebElement searchBoxWithID = driver.findElement(By.id("global-enhancements-search-query"));
        WebElement searchBoxWithName = driver.findElement(By.name("search_query"));
        String textToSearch = "wooden spoon";
        searchBoxWithName.sendKeys(textToSearch + Keys.ENTER);
        //searchBoxWithID.sendKeys(textToSearch + Keys.ENTER);


        String expectedTitle = "Wooden spoon - Etsy";
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Actual title: " + actualTitle + ", matches expected title: " + expectedTitle + " = Test is past");
        }else{
            System.err.println("Actual title: " + actualTitle + ", DOES NOT match expected title:  " + expectedTitle + " = Test fail");
        }
    }
}
