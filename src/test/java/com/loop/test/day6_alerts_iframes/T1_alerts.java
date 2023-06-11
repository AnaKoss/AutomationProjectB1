package com.loop.test.day6_alerts_iframes;

import com.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T1_alerts extends TestBase {

/*
    Information alert practice
    1. Open browser
    2. Go to website: http://the-internet.herokuapp.com/javascript_alerts
    3. Click to “Click for JS Alert” button
    4. Click to OK button from the alert
    5. Verify “You successfully clicked an alert” text is displayed

    Confirmation alert practice
    1. Click to “Click for JS Confirm” button
    2. Click to OK button from the alert
    3. Verify “You clicked: Ok” text is displayed.
    4. Click to “Click for JS Confirm” button
    5. Click to Cancel button from the alert
    6. Validate “You clicked: Cancel” text is displayed.

    Prompt alert practice
    1. Click to “Click for JS Prompt” button
    2. Send "Loop Academy"
    3. Click Ok
    4. Validate "You entered: Loop Academy" text is displayed

 */

    @Test
    public void informationAlert(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        //Click to “Click for JS Alert” button
        WebElement clickForJSAlert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
        clickForJSAlert.click();

        //Click to OK button from the alert
        //driver.switchTo().alert().accept(); it is the same line as #1 and #2
        Alert alert = driver.switchTo().alert(); //object of alert    //#1
       // driver.switchTo().alert().accept(); //the same as the privius one

        alert.accept(); //will click- ok //#2

        //Verify “You successfully clicked an alert” text is displayed
        WebElement successMessageForInformationAlert = driver.findElement(By.xpath("//p[@id='result']"));
         ////p[contains(text()='successfully') or contains(text()='entered') or contains(text()='clicked')]
        String actual = successMessageForInformationAlert.getText();
        String expected = "You successfully clicked an alert";
        assertEquals(actual,expected, "actual does NOT match the expected");

    }
@Test
    public void confitmationAlert(){
    driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    //Click to “Click for JS Alert” button
    WebElement clickForJSConfirm = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
    clickForJSConfirm.click();
    driver.switchTo().alert().accept();
    WebElement successMessageConfirmationAlert = driver.findElement(By.xpath("//p[@id='result']"));
    String actual = successMessageConfirmationAlert.getText();
    String expected = "You clicked: Ok";
    assertEquals(actual, expected, "actual does NOT match the expected");
    clickForJSConfirm.click();
    driver.switchTo().alert().dismiss();//will click cancel = will dismiss
    actual = successMessageConfirmationAlert.getText();
    expected = "You clicked: Cancel";
    assertEquals(actual, expected, "actual does NOT match the expected");
}
@Test
    public void promptAlert (){
    driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    WebElement clickForJSPrompt= driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
    clickForJSPrompt.click();
    String text = "Loop Academy";
//    driver.switchTo().alert().sendKeys("Loop Academy");
//    driver.switchTo().alert().accept();
    Alert alert = driver.switchTo().alert();
    alert.sendKeys(text);
    alert.accept();
    WebElement successMessagePromptAlert = driver.findElement(By.xpath("//p[@id='result']"));
    //we need to get text
    String actual = successMessagePromptAlert.getText();
    String expected = "You entered: " + text;
    assertEquals(actual, expected, "actual does NOT match the expected");

}


//p[contains(text(),'Your content goes here']

}