package com.loop.test.home_tasks.task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
/*
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google
 */
        // set up the driver
        WebDriverManager.chromedriver().setup();

        // create driver object
        WebDriver driver = new ChromeDriver();

        // navigate to google page
        driver.get("https://www.google.com/");

        // maximize the window
        driver.manage().window().maximize();
        WebElement gmail = driver.findElement(By.linkText("Gmail"));
        gmail.click();
        Thread.sleep(3000);
        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Actual title: " + actualTitle + ", matches expected title: " + expectedTitle + ", = Test is past");
        }else{
            System.err.println("Actual title: " + actualTitle + ", DOES NOT match expected title:  " + expectedTitle + ", = Test fail");
        }

        driver.navigate().back();
        String expectedTitle2 = "Google";
        String actualTitle2 = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle2);
        if(actualTitle.contains(expectedTitle2)){
            System.out.println("Actual title: " + actualTitle2 + ", matches expected title: " + expectedTitle2 + ", = Test is past");
        }else{
            System.err.println("Actual title: " + actualTitle2 + ", DOES NOT match expected title:  " + expectedTitle2 + ", = Test fail");
        }


    }
}