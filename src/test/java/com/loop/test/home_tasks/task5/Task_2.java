package com.loop.test.home_tasks.task5;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task_2 {
    /*
    1. go to https://www.etsy.com/
2. search for rings
3. validate that Estimated Arrival shows any time
3. click Estimated Arrival dropdown
4. click Select custom date
5. choose may 30 from dropdown
6. validate Estimated Arrival shows may 30
     */

WebDriver driver;
String actual;
String expected;


@BeforeMethod
    public void setUpMethod(){
    driver = WebDriverFactory.getDriver("chrome");
    driver.get("https://www.etsy.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

    @Test
    public void testDropDown() throws InterruptedException {
    //search for rings
        WebElement searchBoxWithName = driver.findElement(By.name("search_query"));
        String textToSearch = "rings";
        searchBoxWithName.sendKeys(textToSearch + Keys.ENTER);

    //validate that Estimated Arrival shows any time
        WebElement estimatedArrivalAnyTime = driver.findElement(By.xpath("(//*[contains(text(),'Estimated Arrival')])[1]"));
        //and (//*[contains(text(),'Any time')])[1]
        if (estimatedArrivalAnyTime.isDisplayed()) {
            System.out.println("Element found using text: " + estimatedArrivalAnyTime.getText());
        } else
            System.out.println("Element" + estimatedArrivalAnyTime.getText()+ " not found");


    //click Select custom date
        WebElement arrivalAnyTime = driver.findElement(By.xpath("(//*[contains(text(),'Estimated Arrival')])[1]"));
        arrivalAnyTime.click();
        Thread.sleep(3000);
        WebElement selectCustomDate = driver.findElement(By.xpath("(//parent::div[@class=\"wt-select wt-pl-xs-4\"])[1]"));
        //  //*[contains(text(),'Select custom date')])[1]
        //(//parent::div[@class="wt-select wt-pl-xs-4"])[1]
        selectCustomDate.click();

    //choose may 30 from dropdown
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='edd_select_tf']")));
        //WebElement selectMay30 = driver.findElement(By.xpath("(//*[contains(text(),'By May 30')])[1]"));
        dropdown.selectByVisibleText("By May 30");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"By May 30");

        //Select may30 = new Select(driver.findElement(By.name("Select custom date")));
       // may30.selectByVisibleText("By May 30");

       // actual = may30.getFirstSelectedOption().getText();
       // Assert.assertEquals(actual, expected, "does not match");

    //validate Estimated Arrival shows may 30

     WebElement estimatedArrivalByMay30 = driver.findElement(By.xpath("(//parent::span[@class='wt-text-caption'])[1]"));
       if (estimatedArrivalByMay30.isDisplayed()) {
           System.out.println("Element found using text: " + estimatedArrivalByMay30.getText());
       } else
           System.out.println("Element" + estimatedArrivalByMay30.getText()+ " not found");

    }







}
