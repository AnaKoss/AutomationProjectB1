package com.loop.test.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class BrowserUtils {
    /**
     * validate if driver switched to expected url and title
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @autor Ana
     * note: usually we do not do validation in method, tjis is for practicing purpose
     */
    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle){
        expectedUrl = expectedUrl.toLowerCase();
        expectedTitle = expectedTitle.toLowerCase();
        Set <String> windowHandles = driver.getWindowHandles();
        for(String each: windowHandles){
            driver.switchTo().window(each);
            if(driver.getCurrentUrl().toLowerCase().contains(expectedUrl)){
                break;
            }
        }
       assertTrue(driver.getTitle().contains(expectedTitle));
    }

    /**
     * switches to new window by the exact title
     * returns to original
     * it is reusable method
     */
    public static void switchToWindow(WebDriver driver, String targetTitle){
        String origin = driver.getWindowHandle();
        for(String handle: driver.getWindowHandles()){
            driver.switchTo().window(handle);
            if(driver.getTitle().contains(targetTitle)){
                return;
            }
        }

        driver.switchTo().window(origin);
}

/**
 *
 * @param driver
 * @param expectedTitle
 * returns void, assertion is implemented
 * reusable method
 * @aoutor: Ana
 */

public static void validateTitle(WebDriver driver, String expectedTitle){
    assertTrue(driver.getTitle().contains(expectedTitle));

}

}
