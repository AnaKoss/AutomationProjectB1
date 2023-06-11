package com.loop.test.home_tasks.task5;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Task_3 {
    /*
    go to https://app.docuport.app/company-formation/resident
What type of business do you want to start? - choose corporation
Validate that corporation has been selected
Formation State - choose Virginia
Validate Virginia is selected
Validate order summer as below:

State registration fee $100
Payment processing $6
Service fee $150
Total $256

Formation State - choose Maryland
Validate Maryland is selected
Validate order summer as below:

State registration fee $170
Payment processing $10.20
Service fee $150
Total $330.20
     */

    WebDriver driver;


    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://app.docuport.app/company-formation/resident");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //What type of business do you want to start? - choose corporation
        @Test
        public void docuportTest() throws InterruptedException {
            WebElement corporationButton = driver.findElement(By.xpath("(//parent::div[@class='v-radio theme--light'])[1]"));
            corporationButton.click();


    //Validate that corporation has been selected

            if (corporationButton.isDisplayed()) {
                System.out.println("Element found using text: " + corporationButton.getText());
            } else
                System.out.println("Element" + corporationButton.getText()+ " not found");

    //Formation State - choose Virginia


            //want to create reusable method or

            //WebElement radiogroup = driver.findElements(By.xpath("//div[@role='radiogroup']"));
           // System.out.println(driver.findElements(By.xpath("//div[@role='radiogroup']")).size();
            driver.findElements(By.xpath("")).get(2).click();



            ////parent::div[@role='radiogroup']
     WebElement selectVirginiaState = driver.findElement(By.xpath("(//div[@class='v-input--selection-controls__input'])[5]"));


     //WebElement selectVirginiaState = driver.findElement(By.xpath("(//parent::div[@class='v-radio theme--light v-item--active'])[2]"));

        //not working
    // WebElement selectVirginiaState = driver.findElement(By.xpath("(//parent::div[@class='v-radio theme--light v-item--active'])[2]"));

    //WebElement selectVirginiaState = driver.findElement(By.xpath("(//div[@class='v-radio theme--light v-item--active'])[2]"));

        selectVirginiaState.click();

    //Validate Virginia is selected --i can not validate

            if (selectVirginiaState.isDisplayed()) {
                System.out.println("Element found using text: " + selectVirginiaState.getText());
            } else
                System.out.println("Element" + selectVirginiaState.getText()+ " not found");


/*
Validate order summer as below:

State registration fee $100
Payment processing $6
Service fee $150
Total $256
 */
          WebElement stateRegistrationFee = driver.findElement(By.xpath(""));
          String actualStateRegistrationFee ="";



          WebElement paymentProcessing = driver.findElement(By.xpath(""));
          WebElement serviceFee = driver.findElement(By.xpath(""));
          WebElement total = driver.findElement(By.xpath(""));




        }

    }



