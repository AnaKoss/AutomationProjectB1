package com.loop.test.day1_Selemium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {


        //setting up the web driver
        WebDriverManager.chromedriver().setup(); //abstract class

        //create instance of driver
        WebDriver driver = new ChromeDriver(); //chrome driver = object; webDriver - interface
        //Thread.sleep(3000);
        //driver.get("https://www.etsy.com/"); //navigate to url we want

        //maximize
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();
        //Thread.sleep(3000);

        //navigate to
        driver.navigate().to("https://www.etsy.com/");
        //Thread.sleep(3000);

        // let's slow things a bit in order to be able to see what is going on
        //Thread.sleep(3000);

        //navigate.back _ to go back to data
        driver.navigate().back();

        //navigate forward
        driver.navigate().forward();

        //navigate refresh
        driver.navigate().refresh();

    }
}
