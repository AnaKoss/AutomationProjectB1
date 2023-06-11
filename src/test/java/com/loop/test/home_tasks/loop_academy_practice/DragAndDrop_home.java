package com.loop.test.home_tasks.loop_academy_practice;

import com.loop.home_pages.LoopAcademyPracticeDragDropHome;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDrop_home {

    LoopAcademyPracticeDragDropHome loopAcademyPracticeDragDropHome;
    Actions actions;

    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get("https://loopcamp.vercel.app/drag-and-drop.html");
        loopAcademyPracticeDragDropHome = new LoopAcademyPracticeDragDropHome();
        actions = new Actions(Driver.getDriver());

    }

    /*
    click and move boxA
    click and move boxB
    click on LOOPCAMP in new page
    click on loopAcademy in new page
    verify names on boxes and titele

     */
    @Test
    public void boxA (){
        loopAcademyPracticeDragDropHome = new LoopAcademyPracticeDragDropHome();
        actions.moveToElement(loopAcademyPracticeDragDropHome.boxA)
                .clickAndHold()
                .moveByOffset( 200, -200)
                .pause(2000)
                .release()
                .perform();
        String actual = loopAcademyPracticeDragDropHome.boxA.getText();
        String expected = "A";
        Assert.assertEquals(actual, expected, "Does not match");

    }

    @Test
    public void boxA_change_place(){
        loopAcademyPracticeDragDropHome = new LoopAcademyPracticeDragDropHome();
        actions.moveToElement(loopAcademyPracticeDragDropHome.boxA)
                .clickAndHold()
                .moveToElement(loopAcademyPracticeDragDropHome.boxB)
                .pause(2000)
                .release()
                .perform();
        String actual = loopAcademyPracticeDragDropHome.boxB.getText();
        String expected = "B";
        Assert.assertEquals(actual, expected, "Does NOT match");

    }

}
