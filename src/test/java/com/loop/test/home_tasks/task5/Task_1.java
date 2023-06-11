package com.loop.test.home_tasks.task5;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Task_1 {
    /*
    1. go to http://the-internet.herokuapp.com/dropdown
2. validate "Please select an option" is selected by default
3. Choose option 1 and validate that it is selected
4. Choose option 2 and validate that it is selected
5. Validate dropdown name is "Dropdown List"

     */
WebDriver driver;
    String expected ="Please select the option";
    String actual;

       @BeforeMethod
       public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       }

       @Test
        public void selectOptions() {
//           WebElement selectOptionText = driver.findElement(By.xpath("//*[text()='Please select an option']"));
//           if (selectOptionText.isDisplayed()) {
//               System.out.println("Element found using text");
//           } else
//               System.out.println("Element not found");
//          // driver.quit();
//


           //validate "Please select an option" is selected by default
           WebElement selectOptionText = driver.findElement(By.id("dropdown"));

           if (selectOptionText.isDisplayed()) {
              System.out.println("Element found using text: "+ selectOptionText.getText());
              } else
                System.out.println("Element" +selectOptionText.getText() +" not found");
           selectOptionText.click();
           //choose by index
           Select dropdown1 = new Select(driver.findElement(By.id("dropdown")));
           dropdown1.selectByIndex(0);
           assertEquals(dropdown1.getFirstSelectedOption().getText(),"Option 1");

           //Choose option 1 and validate that it is selected
//           WebElement option1 = driver.findElement(By.xpath("//*[text()='Option 1']"));
//           option1.click();
//
//           if (option1.isDisplayed()) {
//               System.out.println("Element found using text: " + option1.getText());
//           } else
//               System.out.println("Element" + option1.getText()+ " not found");

           //Choose option 2 and validate that it is selected
//           WebElement option2 = driver.findElement(By.xpath("//*[text()='Option 2']"));
//           option2.click();
//
//           if (option2.isDisplayed()) {
//               System.out.println("Element found using text: " + option2.getText());
//           } else
//               System.out.println("Element" + option2.getText()+ " not found");

//select by index
           Select dropdown2 = new Select(driver.findElement(By.id("dropdown")));
           dropdown2.selectByIndex(1);
           assertEquals(dropdown2.getFirstSelectedOption().getText(),"Option 2");

        //Validate dropdown name is "Dropdown List"

           WebElement dropdownListName = driver.findElement(By.xpath("//h3['Dropdown']"));

           if (dropdownListName.isDisplayed()) {
               System.out.println("Element found using text: " + dropdownListName.getText());
           } else
               System.out.println("Element" + dropdownListName.getText()+ " not found");

//           Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
//           //give us what is already selected
//           //return web element
//           //actual = dropdown.getFirstSelectedOption().getText();
//
//           Assert.assertEquals(actual, expected, "does not match");

           driver.quit();
       }

       }

