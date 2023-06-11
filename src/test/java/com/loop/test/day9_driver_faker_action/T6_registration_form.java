package com.loop.test.day9_driver_faker_action;

import com.github.javafaker.Faker;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T6_registration_form {
    /*
    1. go to url:  https://loopcamp.vercel.app/
    2. fill the form
    3. use faker
     */

    @Test

    public void registration_form_test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("loop.practice"));
        WebElement registrationForm = Driver.getDriver().findElement(By.xpath("//a[.='Registration Form']"));

        registrationForm.click();
        Faker faker = new Faker();
        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys(faker.bothify("???###"));

        WebElement email = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(faker.internet().emailAddress());

        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.internet().password());


        WebElement phoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys(faker.numerify("571-###-####"));


        WebElement gender = Driver.getDriver().findElement(By.xpath("//input[@value='other']"));
        gender.click();

        WebElement dateOfBirth = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        //dateOfBirth.sendKeys(faker.date().birthday().toString());

        dateOfBirth.sendKeys(faker.numerify("##/##/####"));

    }


}
