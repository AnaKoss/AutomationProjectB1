package com.loop.test.day7_windows_webtables;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtils;
import com.loop.test.utilities.DocuportWebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_webTables extends TestBase {
    /*
    1. login as an advisor
    2. go to users
    3. validate that full name for alex.de.souza@gmail.com is Alex De Souza
    4. validate that user name for alex.de.souza@gmail.com is alexdesouze
    5. validate that phone number for alex.de.souza@gmail.com is +994512060042
    6. validate that role for alex.de.souza@gmail.com is client
    7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
     */


    @Test
    public void test_web_tables (){
        DocuportUtils.login(driver, DocuportConstants.ADVISOR);
        WebElement users = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        users.click();

       String actual =  DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "Full name");

       String expected = "Alex De Souza";
        System.out.println("actual: "+ actual);
       Assert.assertEquals(actual,expected);

       String actualUserName = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "Username");
       String expectedUserName = "alexdesouze";
        System.out.println("actual user name: " + actualUserName);
        Assert.assertEquals(actualUserName, expectedUserName);
    }


}


/*

we need to add cases:
phone #, role, inviter, advisor, user name
1 test case superviser
2 test case for souza
3 test case for adviser 
case "phone number":
                xpath = "//td[2][contains(text(),'"+ emailAddress+"')]/following-sibling::td[2]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "role":
                xpath = "//td[2][contains(text(),'"+ emailAddress+"')]/following-sibling::td[4]";
                element = driver.findElement(By.xpath(xpath));
                break;
            default: throw new InputMismatchException("Wrong input: " + field);
 */