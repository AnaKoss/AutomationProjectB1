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

public class Task_2_1 {
    WebDriver driver;
    String actual;
    String expected;


    @BeforeMethod
    public void setUpMethod() {
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
        Assert.assertEquals(estimatedArrivalAnyTime.getText(), "Estimated Arrival Any Time");

        //click Estimated Arrival dropdown
        estimatedArrivalAnyTime.click();
        //click select custom date
        WebElement buttonCustomDate = driver.findElement(By.xpath("//div[@data-custom-edd-container-ft='true']/div/label"));
        buttonCustomDate.click();
        WebElement selectDateDropdown = driver.findElement(By.xpath("(//select[@aria-label='Select custom date'])[1]"));
        selectDateDropdown.click();
        //choose May 30 from dropdown
       Select deliveryDateDropdown = new Select(driver.findElement(By.xpath("//select[@id='edd_select-tf']")));
       deliveryDateDropdown.selectByVisibleText("By May 30");
       Assert.assertEquals(estimatedArrivalAnyTime.getText(), "Estimated Arrival By May 30");
    }
}