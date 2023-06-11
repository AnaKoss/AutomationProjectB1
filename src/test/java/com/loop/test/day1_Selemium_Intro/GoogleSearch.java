package com.loop.test.day1_Selemium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) {

        /**
         * Navigate to Google search
         * maximize the page
         * get title of the page
         * get url of the page
         * validate the title, expected title is "Google"
         * validate the url of the page, expected url is "https://www.google.com/"
         * close the brower
         */


        // setup the driver
        WebDriverManager.chromedriver().setup();

        // create driver object
        WebDriver driver = new ChromeDriver();

        // navigate to google page
        driver.get("https://www.google.com/");

        // maximize the window
        driver.manage().window().maximize();

        String expectedTitle = "Google";
        String expectedUrl = "https://www.google.com/";

        String actualTitle = driver.getTitle();

        System.out.println("actualTitle = " + actualTitle);

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Actual title: " + actualTitle + ", matches expected title: " + expectedTitle + ", =. Test is past");
        }else{
            System.err.println("Actual title: " + actualTitle + ", DOES NOT match expected title:  " + expectedTitle + ", =. Test fail");
        }

        String actualUrl = driver.getCurrentUrl();
        System.out.println("actualURL : " +  actualUrl);

        if(actualUrl.contains(expectedUrl)){
            System.out.println("Actual url: " + actualUrl + ", matches expected url: " + expectedUrl + ", =. Test is past");
        }else{
            System.err.println("Actual url: " + actualUrl + ", DOES NOT match expected url:  " + expectedUrl + ", =. Test fail");
        }



        //quit the browser
        //driver.quit();


    }
}
