package Appium;

import Utilities.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Appium09 extends BaseClass {

   @Test
   public void test() throws MalformedURLException, InterruptedException {

      AndroidDriver driver = getAndroidDriver();


      System.out.println("App intstalled...");
        //api demos butonuna tikla
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(3000);
//preference butonuna tikladik
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        //preference dependencies butonuna bastik
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        //check box check et
        Thread.sleep(3000);
        driver.findElementById("android:id/checkbox").click();
        //wifi setting tikladik
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        //text penceresi acildigini gorduk
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElementById("android:id/alertTitle").isDisplayed());
        //text yazdiralim
        driver.findElementById("android:id/edit").sendKeys("TextAppium");
        //ok butonuna bas
        driver.findElementById("android:id/button1").click();

        System.out.println("mission completed....");

        Thread.sleep(10000);
        //session kapat

        driver.closeApp();
    }
}
