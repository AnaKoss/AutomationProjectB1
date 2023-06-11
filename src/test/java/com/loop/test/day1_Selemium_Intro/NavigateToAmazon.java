package com.loop.test.day1_Selemium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToAmazon {
    //navigate to amazon
    //navigate back
    //forward
    //refresh
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup(); //set up the driver
        WebDriver driver = new ChromeDriver(); //create object of driver //interface -  web driver

        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        //driver.close();
        driver.quit();
    }
}
