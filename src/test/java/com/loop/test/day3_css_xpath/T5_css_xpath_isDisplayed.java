package com.loop.test.day3_css_xpath;

import com.loop.test.utilities.WebDriverFactory;
import com.sun.tools.javac.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_css_xpath_isDisplayed {
    /* go to http://the-internet.herokuapp.com/forgot_password
     *  locate 5 elements, forgot password, email, email input, retrieve password, powered selenium
     *  css
     * verify those elements are displayed
     */


    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/forgot_password");


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




    }
}