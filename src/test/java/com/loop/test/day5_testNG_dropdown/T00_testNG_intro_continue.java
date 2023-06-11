package com.loop.test.day5_testNG_dropdown;

import org.testng.Assert;
import org.testng.annotations.*;

public class T00_testNG_intro_continue {

    @BeforeClass
    public void setUp(){
        System.out.println("Before class is running");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("After class is running");
    }

    @BeforeMethod //using to set up some staff
    public void setUpMethod(){ //create user
        System.out.println("Before method is running");
    }

    @AfterMethod
    public void tearDownMethod(){ //delete user
        System.out.println("After method is running");
    }


    @Test (priority = 2)
    public void test1(){
        System.out.println("testNG test 1 is run");
        String actual = "Loop";
        String expected = "Loop";
        //Assert.assertEquals(actual, expected, "Test is passing");
        Assert.assertEquals(actual, expected, actual + ": is not matching with: " + expected);
    }
@Test (priority = 1)
    public void atest2 (){
    System.out.println("TestNG test 2 is running");

}

}
