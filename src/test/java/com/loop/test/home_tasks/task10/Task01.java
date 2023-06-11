package com.loop.test.home_tasks.task10;

import com.beust.ah.A;
import com.loop.pages.LoopPracticeDragDropPage;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
  /*  task1
1. Open a chrome browser
2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
            3. Click and hold small circle
4. Move it on top of the big circle
5. validate “Now drop…” text appears on big circ
        task2
1. Open a chrome browser
2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
            3. Click and hold small circle
4. Dropped anywhere outside of big circle
5. validate “Try again!” text appears on big circle
   */

/**
 * @autor Ana
 */

public class Task01 {

    LoopPracticeDragDropPage loopPracticeDragDropPage;
    Actions actions;
    String actual;
    String expected;

    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get("https://loopcamp.vercel.app/drag-and-drop-circles.html");
        loopPracticeDragDropPage = new LoopPracticeDragDropPage();
        actions = new Actions(Driver.getDriver());
    }




    @Test
    public void move_to_big_circle(){
loopPracticeDragDropPage = new LoopPracticeDragDropPage();
actions.moveToElement(loopPracticeDragDropPage.smallCircle)
        .clickAndHold()
        .moveByOffset(200, 200)
        .pause(200)
        .moveToElement(loopPracticeDragDropPage.bigCircle)
        .perform();

        actual = loopPracticeDragDropPage.bigCircle.getText();
        expected= "Now drop...";
        assertEquals(actual, expected, "Actual does NOT match with expected");


    }


    @Test
    public void drop_anywhere(){

loopPracticeDragDropPage = new LoopPracticeDragDropPage();
actions.moveToElement(loopPracticeDragDropPage.smallCircle)
        .clickAndHold()
        .moveByOffset(200, 200)
        .pause(2000)
        .release()
        .perform();

expected="Try again!";
actual = loopPracticeDragDropPage.bigCircle.getText();
assertEquals(actual, expected, "Actual does NOT match with expected");

    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}
