package com.loop.test.home_tasks.task3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    /**
     1. go to http://the-internet.herokuapp.com/forgot_password
     2. locate 5 elements, forgot password, email, email input, retrieve password, powered selenium
     3. use css
     4. verify those elements are displayed
     */

    public static void main(String[] args) {

        // set up the driver
        WebDriverManager.chromedriver().setup();

        // create driver object
        WebDriver driver = new ChromeDriver();

        // navigate to google page
        driver.get("http://the-internet.herokuapp.com/forgot_password");

        // maximize the window
        driver.manage().window().maximize();
        WebElement forgetPasswordHeading = driver.findElement(By.cssSelector("div[class='example']>h2"));

        if (forgetPasswordHeading.isDisplayed()) {
            System.out.println("Forget password heading is displayed");
        } else {
            System.out.println("Forget password heading is NOT displayed");
        }

        // WebElement emailHeading = driver.findElement(By.cssSelector("div[class='example']>h4")); //Email heading is NOT displayed
        WebElement emailHeading = driver.findElement(By.cssSelector("div[class='large-6 small-12 columns']"));

        if (emailHeading.isDisplayed()) {
            System.out.println("Email heading is displayed");
        } else {
            System.out.println("Email heading is NOT displayed");
        }


        WebElement emailInput = driver.findElement(By.cssSelector("input[type='text']"));

        if (emailInput.isDisplayed()) {
            System.out.println("Email input is displayed");
        } else {
            System.out.println("Email input is NOT displayed");
        }

        WebElement retrievePassword = driver.findElement(By.cssSelector("i[class='icon-2x icon-signin']"));

        if (retrievePassword.isDisplayed()) {
            System.out.println("Retrieve password is displayed");
        } else {
            System.out.println("Retrieve password is NOT displayed");
        }


        WebElement poweredSelenium = driver.findElement(By.cssSelector("i[class='icon-2x icon-signin']"));

        if (poweredSelenium.isDisplayed()) {
            System.out.println("Powered selenium is displayed");
        } else {
            System.out.println("Powered selenium is NOT displayed");

        }


        driver.quit();
    }
}