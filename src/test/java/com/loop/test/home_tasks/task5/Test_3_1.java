package com.loop.test.home_tasks.task5;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test_3_1 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://app.docuport.app/company-formation/resident");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void testRadioButton(){
        WebElement radioButtonCorporation = driver.findElement(By.xpath("//label[.='Corporation']/../div/i/following-sibling::input/.."));
        WebElement radioButtonStatus = driver.findElement(By.xpath("//label[.='Corporation']/../div/i/following-sibling::input"));
        System.out.println(radioButtonCorporation.isEnabled());
        radioButtonCorporation.click();
        //Validate that corporation has been selected
        Assert.assertTrue(radioButtonStatus.isSelected(),"Radio button was NOT selected");
        WebElement radioButtonVirginia = driver.findElement(By.xpath("//label[.='Virginia']/.."));
        radioButtonVirginia.click();
        WebElement radioButtonVirginia2 = driver.findElement(By.xpath("//input[@id='input-74']"));
        Assert.assertTrue(radioButtonVirginia2.isSelected(), "Radio button was NOT selected");

        //validate order summer as below;
        //State registration fee $100
        WebElement stateRedistrationFee = driver.findElement(By.xpath("//p[contains(text(),'State registration fee')]/following-sibling::p"));
        Assert.assertEquals(stateRedistrationFee.getText(),"$100");
        //payment processing $6
        WebElement paymentProcessing= driver.findElement(By.xpath("//p[contains(text(),'Payment processing')]/following-sibling::p"));
        Assert.assertEquals(paymentProcessing.getText(), "$6");
        //service fee $150
        WebElement serviceFee = driver.findElement(By.xpath("//p[contains(text(),'Service fee')]/following-sibling::p"));
        Assert.assertEquals(serviceFee.getText(), "$150");
        //Total $256
        WebElement total = driver.findElement(By.xpath("//p[contains(text(),'Total')]/../following-sibling::div/p"));
                Assert.assertEquals(total.getText(), "256");
    }

    @Test
    public void testMaryland(){
        WebElement radioButtonMaryland = driver.findElement(By.xpath("//label[.='Maryland']/.."));
        radioButtonMaryland.click();
        WebElement radioButtonMaryland2 = driver.findElement(By.xpath("//input[@id='input-72']"));
        WebElement radioButtonStatus = driver.findElement(By.xpath("//label[.='Maryland']/../div/i/following-sibling::input"));
        Assert.assertEquals(radioButtonStatus.isSelected(), "radio button was NOT selected");
        WebElement stateRegistrationFee = driver.findElement(By.xpath("//p[contains(text(),'State registration fee')]/following-sibling::p"));
        Assert.assertEquals(stateRegistrationFee.getText(), "$170");
        WebElement paymentProcessing = driver.findElement(By.xpath("//p[contains(text(),'Payment processing')]/following-sibling::p"));
        Assert.assertEquals(paymentProcessing.getText(),"$10.20");
        WebElement serviceFee= driver.findElement(By.xpath("//p[contains(text(),'Service fee')]/following-sibling::p"));
        Assert.assertEquals(serviceFee.getText(),"$150");
        WebElement total = driver.findElement(By.xpath("//p[contains(text(),'Total')]/../following-sibling::div/p"));
        Assert.assertEquals(total.getText(),"$330.20");
    }
}
