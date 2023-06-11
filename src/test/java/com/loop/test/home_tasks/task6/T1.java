package com.loop.test.home_tasks.task6;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtils;
import com.loop.test.utilities.DocuportWebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class T1 extends TestBase {
    /*0. complete the method - returnAnyField - that it can handle "phone number", "role", "advisor" fields

    1. login as an advisor
    2. go to users


    3. validate that full name for alex.de.souza@gmail.com is Alex De Souza
    4. validate that user name for alex.de.souza@gmail.com is alexdesouze
    5. validate that phone number for alex.de.souza@gmail.com is +994512060042
    6. validate that role for alex.de.souza@gmail.com is client
    7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1

    repeat the same thing for
    - 	b1g1_supervisor@gmail.com
    -   b1g1_advisor@gmail.com
     */


    @Test
    public void returnAnyField (){
        DocuportUtils.login(driver, DocuportConstants.ADVISOR);
        WebElement users = driver.findElement(By.xpath(DocuportConstants.USERS));
        users.click();

        String actual =  DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "Full name");
        String expected = "Alex De Souza";
        System.out.println("actual: "+ actual);
        Assert.assertEquals(actual,expected);

        String actualUserName = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "Username");
        String expectedUserName = "alexdesouze";
        System.out.println("actual user name: " + actualUserName);
        Assert.assertEquals(actualUserName, expectedUserName);


//        String actualPhoneNumber = DocuportWebTableUtils.returnAnyField(driver, "+994512060042", "phone number");
//        String expectedPhoneNumber = "+994512060042";
//        System.out.println("actual phone number: " + actualUserName);
//        Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber);


        String actualRole = DocuportWebTableUtils.returnAnyField(driver, "Client", "Role");
        String expectedRole = (DocuportConstants.CLIENT);
        System.out.println("actual role: " + actualRole);
        Assert.assertEquals(actualRole, expectedRole);
}
}
