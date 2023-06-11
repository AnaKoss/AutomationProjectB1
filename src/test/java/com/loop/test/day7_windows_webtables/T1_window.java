package com.loop.test.day7_windows_webtables;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class T1_window extends TestBase {

   /*
    1. Open a chrome browser
    2. Go to : http://the-internet.herokuapp.com/windows
    3. Assert: Title is “The Internet”
    4. Click to: “Click Here” link
    5. Switch to new Window.
    6. Assert: Title is “New Window”
     */

    @Test
    public void test_window_handle(){
        driver.get("http://the-internet.herokuapp.com/windows");
        //Assert.assertEquals(driver.getTitle(),"The Internet");

       assertTrue(driver.getTitle().contains("The Internet"));
        WebElement clickHere = driver.findElement(By.xpath("//a[@href='/windows/new']"));
        clickHere.click();



       // WebElement newWindow = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]"));
        //System.out.println(newWindow.getText());

        //System.out.println("This is my window handle " + driver.getWindowHandle()); // will print ID for window

       Set <String> windowHandles = driver.getWindowHandles(); //return type SET not allows duplicates!!!!

        for (String each: windowHandles){
            System.out.println("each window's handle: " + each);
            driver.switchTo().window(each); //without this line they will not show the new page in selenium

        }
       // System.out.println("each window's handle: " + driver.getWindowHandle());
        System.out.println("this is my current URL: " + driver.getCurrentUrl());
        System.out.println("this is my current title: " + driver.getTitle());

        WebElement newWindow = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]"));
        System.out.println(newWindow.getText());
    }


}
