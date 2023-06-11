package com.loop.test.home_tasks.task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    /*
    1. Open Docuport app
2. Send UserName
3. Send password
4. Click login

make sure inputs which have numbers are dynamic or not
     */
    public static void main(String[] args) throws InterruptedException {

        // set up the driver
        WebDriverManager.chromedriver().setup();

        // create driver object
        WebDriver driver = new ChromeDriver();

        // navigate to google page
        driver.get("https://beta.docuport.app/login");

        // maximize the window
        driver.manage().window().maximize();

//for client
        //userName--> b1g2_client@gmail.com
        //password --> Group2

        WebElement userName = driver.findElement(By.id("input-14"));

        userName.sendKeys("b1g2_client@gmail.com");

        WebElement password = driver.findElement(By.id("input-15"));

        password.sendKeys("Group2");

        //WebElement login = driver.findElement(By.className("text-none body-2 font-weight-medium v-btn v-btn--block v-btn--has-bg theme--light v-size--large primary"));
        //login.click();
        Thread.sleep(3000);
        password.sendKeys(Keys.ENTER);


    }
}
