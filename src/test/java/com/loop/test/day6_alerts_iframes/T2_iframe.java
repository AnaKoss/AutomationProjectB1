package com.loop.test.day6_alerts_iframes;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class T2_iframe extends TestBase {
    /*
        1- Open a chrome browser
        2- Go to: http://the-internet.herokuapp.com/iframe
        3- Clear text from comment body
        4- Type "Loop Academy" in comment body
        5- Verify "Loop Academy" text is written in comment body
        6- Verify header "An iFrame containing the TinyMCE WYSIWYG Editor" is displayed

         */
    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/iframe");

       // WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
       // driver.switchTo().frame(iframe);  //switching to iframe

       // driver.switchTo().frame(0); //using index

        driver.switchTo().frame("mce_0_ifr"); //id

        WebElement textBox= driver.findElement(By.xpath("//*[@id='tinymce']"));
        textBox.clear();
        textBox.sendKeys("Loop Academy");
        Thread.sleep(3000);
        driver.switchTo().defaultContent(); //it will take us directly to main html
        //driver.switchTo().parentFrame();    //this will take us to parent frame(second/privius iframe)

        WebElement heading = driver.findElement(By.xpath("//h3[contains(text(),'An iFrame containing')]"));
        String actual = heading.getText();
        String expected = "An iFrame containing the TinyMCE WYSIWYG Editor";
        assertEquals(actual, expected, "actual does NOT match with expected");
    }

    @Test
    public void amazonIframe(){
        driver.get("http://www.amazon.com/");
        //List<WebElement> iframe = new



    }

}
