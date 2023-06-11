package com.loop.test.home_tasks.task3;

import com.loop.test.utilities.DocuportConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    /**
     * 1. login to docuport application
     * 2. logout from docuport application
     * 3. Validate successful login
     * 4. Validate successful logout
     */
    public static void main(String[] args) throws InterruptedException {

        // set up the driver
        WebDriverManager.chromedriver().setup();

        // create driver object
        WebDriver driver = new ChromeDriver();

        // navigate to google page
        driver.get("https://beta.docuport.app");

        // maximize the window
        driver.manage().window().maximize();

        //login to docuport application

        WebElement userName = driver.findElement(By.cssSelector("input[id='input-14']"));
        userName.sendKeys(DocuportConstants.USERNAME_CLIENT);

        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys(DocuportConstants.PASSWORD_CLIENT);

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        WebElement homeIcon = driver.findElement(By.cssSelector("i[class='v-icon notranslate mdi mdi-home theme--light']"));
        //validate successful login
        if(homeIcon.isDisplayed()){
            System.out.println("Login was successful");
        }else {
            System.out.println("Login was unsuccessful");
        }

        WebElement dropDown=driver.findElement(By.cssSelector("div[class='v-avatar primary']>span"));
        dropDown.click();
        Thread.sleep(3000);
        WebElement logOut = driver.findElement(By.cssSelector("div#list-item-88"));
        logOut.click();
        WebElement loginHeader = driver.findElement(By.cssSelector("img[alt='Docuport']"));
        String expectedLoginHeader = "Docuport";
        boolean actualLoginHeader =loginHeader.isDisplayed();
        if(actualLoginHeader){
            System.out.println("Logout was successful");
        }else {
            System.out.println("Logout was not successful");
        }

        Thread.sleep(1500);


       driver.quit();
    }
}
