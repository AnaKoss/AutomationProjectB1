package com.loop.test.home_tasks.task9;

import com.github.javafaker.Faker;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

public class T1 {
    /*
    1. go to url: https://loopcamp.vercel.app/registration_form.html
2. fill the form
3. use faker
     */

    @Test
    public void fill_the_form_faker(){
        Driver.getDriver().get(ConfigurationReader.getProperty("loop.practice"));

        WebElement registrationForm = Driver.getDriver().findElement(By.xpath("//a[text()='Registration Form']"));
        registrationForm.click();

        WebElement form = Driver.getDriver().findElement(By.xpath("//h2[text()='Registration form']"));
        form.isDisplayed();

        Faker faker = new Faker ();

WebElement firstName = Driver.getDriver().findElement(By.name("firstname"));
firstName.sendKeys(faker.name().firstName());

WebElement lastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
lastName.sendKeys(faker.name().lastName());

WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
userName.sendKeys(faker.bothify("???###"));

WebElement emailAddress = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
emailAddress.sendKeys(faker.internet().emailAddress());

WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
password.sendKeys(faker.internet().password());

WebElement phoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
phoneNumber.sendKeys(faker.numerify("512-###-####"));

WebElement gender = Driver.getDriver().findElement(By.xpath("//input[@name='gender']"));
gender.click();


//SimpleDateFormat birthDay = new SiimpleDAteFormat();
//    Faker faker = new Faker();
//
//            WebElement dateOfBirth = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
//dateOfBirth.sendKeys(faker.date().birthday());




    }
}
