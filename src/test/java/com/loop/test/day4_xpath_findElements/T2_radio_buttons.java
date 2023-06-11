package com.loop.test.day4_xpath_findElements;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T2_radio_buttons {
    public static void main(String[] args) throws InterruptedException {
       /*
       https://demoqa.com/radio-button
       wait implicitly 10 seconds
        */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //--> selenium 3
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //--> selenium 4

        WebElement radioYes = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        WebElement radioNo = driver.findElement(By.xpath("//input[@id='noRadio']"));

        // isSelected()

        System.out.println(radioYes.isSelected() + " before clicking");
        radioYes.click();
        Thread.sleep(5000);
        System.out.println(radioYes.isSelected() + " after clicking");

        System.out.println("radioNo = " + radioNo.isEnabled());
        System.out.println("radioYes = " + radioYes.isEnabled());






    }

}
