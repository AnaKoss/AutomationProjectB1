package com.loop.test.day10_jsexecutor_pom;

import com.beust.ah.A;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T1_JSExecutor_scroll {

 /*
    1. Go to https://www.etsy.com
    2. Scroll down
    3. Generate random email and enter into subscribe box
    4. Click on Subscribe
    5. Verify "Great! We've sent you an email to confirm your subscription." is displayed
     */

    @Test
    public void etsy_scroll_test(){

        Driver.getDriver().get(ConfigurationReader.getProperty("etsy.url"));

        WebElement emailBox = Driver.getDriver().findElement(By.id("email-list-signup-email-input"));
        ////input[@id='email-list-signup-email-input'] --xpath

        //how to scroll to element

        //create the object of action class
        //#1 use action move to element

        Actions actions = new Actions(Driver.getDriver());
       // actions.moveToElement(emailBox).perform();

        //#2 use Key press

        //actions.sendKeys(Keys.ARROW_DOWN).perform(); //Keys.PAGE_DOWN
        //actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform(); //Keys.PAGE_DOWN
        //actions.scrollToElement(emailBox).perform();


        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //#3 scroll horizontally or vertically
        //js.executeScript("window.scrollBy(0,5000)");

        //#4
        js.executeScript("arguments[0].scrollIntoView(true)", emailBox);
        js.executeScript("arguments[0].click", emailBox);

    }
}
