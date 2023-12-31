package com.loop.test.day8_webtables_config;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.PizzaOrderWebTableUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T0_pizza_order extends TestBase {


    /*
      /*
    1. go to https://loopcamp.vercel.app/web-tables.html
    2. create a method to test given field for a given name
     */


    @Test
    public void validate_card_for_alexandra() {
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        String name = "Alexandra Gray";
        String expectedCardNumber = "321456789012";
        String actualCardNumber = driver.findElement(By.xpath("//td[contains(text(),'321456789012')]")).getText();
        assertEquals(actualCardNumber, expectedCardNumber);
        assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Card Number"), expectedCardNumber);
    }
        @Test
          public void test_pizza_type(){
            driver.get("https://loopcamp.vercel.app/web-tables.html");
            String name = "Alexandra Gray";
            String expectedPizzaType = "Thin Crust";
            assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(driver,name, "Pizza type"), expectedPizzaType);
    }

        @Test
        public void test_amount(){
            driver.get("https://loopcamp.vercel.app/web-tables.html");
            String name = "John Doe";
            String expectedAmount = "3";
            assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(driver,name, "Amount"), expectedAmount);
    }

        @Test
        public void test_date(){
            String name = "Alexandra Gray";
            String expectedDate = "321456789012";
    }

        @Test
        public void test_street(){

    }

        @Test
        public void test_city(){

    }

    @Test
    public void test_state(){

    }

    @Test
    public void test_zip(){

    }

    @Test
    public void test_card(){

    }

    @Test
    public void test_card_numbner(){

    }

    @Test
    public void test_exp(){

    }
    }

