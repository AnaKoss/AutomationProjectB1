package com.loop.test.day4_xpath_findElements;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T1_findElements {

/*
1. open a chrome browser
2.go to the https://www.nba.com/
3. locate all the links in the page
4- Print out the number of the links on the page.
5- Print out the texts of the links.
6- Print out the HREF attribute values of the links
 */



    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.nba.com/");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //--> selenium 3
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //--> selenium 4


        List<WebElement> nbaLinks = driver.findElements(By.tagName("a"));

        System.out.println("NBA links: " + nbaLinks.size());

        List<WebElement> nbaLinksXpath = driver.findElements(By.xpath("//a"));
        System.out.println("NBA links Xpath: " + nbaLinksXpath.size());

        for (WebElement nbaLink : nbaLinks) {
            if (!nbaLink.getText().equals("")) {
                System.out.println("nbaLink = " + nbaLink.getText());
                System.out.println("nbaLink = " + nbaLink.getAttribute("href"));
            }
        }

        for (int i = 0; i < nbaLinks.size(); i++) {
            if(!nbaLinks.get(i).getText().equals("")) {
                System.out.println("nbaLink = " + nbaLinks.get(i).getText());
                System.out.println("nbaLink = " + nbaLinks.get(i).getAttribute("href"));
            }
        }


    }
}
