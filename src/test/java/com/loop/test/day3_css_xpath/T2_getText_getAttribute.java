package com.loop.test.day3_css_xpath;

import com.loop.test.utilities.DemoQaConstants;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {
    /*
     * go to url: https://demoqa.com/automation-practice-form
     * verify header text expected - Student registration form
     * verify placeholder attribute value is expected - username
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");

        //WebElement headerForForm = driver.findElement(By.tagName("h5"));
        String actualHeaderForFrom = driver.findElement(By.tagName("h5")).getText();

        if (actualHeaderForFrom.equals(DemoQaConstants.EXPECTED_HEADER_FOR_FORM)){
            System.out.println("Expected header for form: \"" + DemoQaConstants.EXPECTED_HEADER_FOR_FORM + "\", matches actual error message: \"" + actualHeaderForFrom + "\" = Test PASSED");
        } else {
            System.out.println("Expected header for form: \"" + DemoQaConstants.EXPECTED_HEADER_FOR_FORM + "\", DOES NOT match actual error message: \"" + actualHeaderForFrom);
            System.err.println("TEST FAILED");
        }


        //get placeholder

        WebElement firstNamePlaceHolder = driver.findElement(By.id("firstName"));
        String actualPlaceHolderFirstName = firstNamePlaceHolder.getAttribute("placeholder");
        //System.out.println(firstNamePlaceHolder.getText()+ " ===> this is from get text");
        //System.out.println(firstNamePlaceHolder.getAttribute("placeholder"));

//validation
        if (actualPlaceHolderFirstName.equals(DemoQaConstants.EXPECTED_PLACE_HOLDER_FIRST_NAME)){
            System.out.println("Expected placeholder: \"" + DemoQaConstants.EXPECTED_PLACE_HOLDER_FIRST_NAME + "\", matches actual placeholder: \"" + actualPlaceHolderFirstName + "\" = Test PASSED");
        } else {
            System.out.println("Expected placeholder: \"" + DemoQaConstants.EXPECTED_PLACE_HOLDER_FIRST_NAME + "\", DOES NOT match actual placeholder: \"" + actualPlaceHolderFirstName);
            System.err.println("TEST FAILED");
        }
        driver.quit();
    }


}
