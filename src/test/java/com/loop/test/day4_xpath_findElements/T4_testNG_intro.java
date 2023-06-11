package com.loop.test.day4_xpath_findElements;

import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_testNG_intro {

@Test
    public void test (){
    System.out.println("TestNG is running");

    String actual = "feuruz";
    String expected = "feyruz";

    Assert.assertEquals(actual, expected); //static call by class name

}

}
/*
What kind of method .assertEquals() is?

Hint: we are calling it with the class name.
 */