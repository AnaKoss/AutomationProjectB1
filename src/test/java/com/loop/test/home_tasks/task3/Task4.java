package com.loop.test.home_tasks.task3;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Task4  {
    /*
    go to docuport
    click on forget password
    verify the reset password

     */
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://app.docuport.app/login?redirect=%2F");

        WebElement forgetPassword = driver.findElement(By.cssSelector("a[class='body-2 text-decoration-none primary--text']"));
        forgetPassword.click();

       // driver.getCurrentUrl().contains("reset");

       //String actualResetPasswordMessage = driver.findElement(By.tagName("h1")).getText();
WebElement resetPasswordMessage = driver.findElement(By.cssSelector("h1[class='text-h5 font-weight-medium mb-6']"));
        //System.out.println(resetPasswordMessage.getText());
        System.out.println(resetPasswordMessage.isDisplayed());
    }
}
