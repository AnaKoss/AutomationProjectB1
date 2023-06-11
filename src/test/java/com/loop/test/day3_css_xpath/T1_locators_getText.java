package com.loop.test.day3_css_xpath;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_locators_getText {

    /**
     * go to docuport
     * enter username
     * enter password
     * click on Log in button
     * verify error massage
     */
    public static void main(String[] args) throws InterruptedException {
        //go to url

       //driver object     //utilizing my utiliety in order to create the driver object
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // maximize the window
        driver.manage().window().maximize();

        // navigate to google page
        driver.get("https://beta.docuport.app/login"); // we can use navigate accepts get

        //interface           //signed locater for that
        WebElement userName = driver.findElement(By.id("input-14"));
       // userName.sendKeys("b1g2_client@gmail.com");
        userName.sendKeys(DocuportConstants.USERNAME_CLIENT); // creating constant--> you can change quickly. only change in one place
        userName.clear(); //part of the web element
        //driver.navigate().refresh();

      //  WebElement password = driver.findElement(By.id("input-15"));
       // Thread.sleep(3000);
       // userName.clear();
        //password.sendKeys ("Group2");
       // password.sendKeys(DocuportConstants.PASSWORD_CLIENT);

        WebElement loginButton = driver.findElement(By.className("v-btn__content"));
        loginButton.click();
        WebElement errorMessageForEmptyPassword = driver.findElement(By.className("v-messages__message"));
        String actualErrorMassage = errorMessageForEmptyPassword.getText();

        if(actualErrorMassage.equals(DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD)){
            System.out.println("Actual title: " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + ", matches expected title: " + actualErrorMassage + " = Test is past");
        }else{
            System.err.println("Actual title: " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + ", DOES NOT match expected title:  " + actualErrorMassage + " = Test fail");
        }
driver.quit();

    }
}
