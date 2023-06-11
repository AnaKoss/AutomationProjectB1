package com.loop.test.day1_Selemium_Intro;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Locators {
    public static void main(String[] args) throws InterruptedException {

        // set up the driver
        WebDriverManager.chromedriver().setup();

        // create driver object
        WebDriver driver = new ChromeDriver(); //create object of driver //interface -  web driver

        // navigate to google page
        driver.get("https://www.google.com/");

        // maximize the window
        driver.manage().window().maximize();

        WebElement searchBoxWithID = driver.findElement(By.id("APjFqb")); //creating element, and identify the location the element on the page by ID
        WebElement searchBoxWithName = driver.findElement(By.name("q"));
        //create a String what you want to search
        //String textToSearch= "Loop Academy";
        //searchBoxWithID.sendKeys(textToSearch + Keys.ENTER);

        WebElement aboutLink = driver.findElement(By.linkText("About")); // identify the About link

        //aboutLink.click();

        //create a String what you want to search
        String textToSearch= "Loop Academy";
        //searchBoxWithID.sendKeys(textToSearch + Keys.ENTER);
        searchBoxWithID.sendKeys(textToSearch);
        Thread.sleep(3000);
        searchBoxWithID.clear();

    }

}
