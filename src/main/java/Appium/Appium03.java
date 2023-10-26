package Appium;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium03 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
       // capabilities.setCapability("platformName","Android");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\burak\\ideaProject\\Appium\\src\\Apps\\gestureTool.apk");
        capabilities.setCapability("appPackage","com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability("noReset", "true");
        AndroidDriver<MobileElement> driver=new AndroidDriver(new URL("http://127.0.0.1:4723/"),capabilities);

        //asadidaki kod tel kilitli ise acmamizi sagliyor

        if (driver.isDeviceLocked()) {
            driver.unlockDevice();
        }

        System.out.println("app yuklendi");

        Thread.sleep(2000);
        MobileElement homeScreenTitle = driver.findElementById("android:id/title");
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("Ana sayfa acildi");

        Thread.sleep(2000);
        MobileElement testButton = driver.findElementById("com.davemac327.gesture.tool:id/testButton");
        testButton.click();
        System.out.println("Test button calisiyor :)");

        Thread.sleep(2000);
        MobileElement testAGestureTitle = driver.findElementById("android:id/title");
        Assert.assertTrue(testAGestureTitle.isDisplayed());
        System.out.println("test screen acildi...");


        //session kapat
        driver.closeApp();

    }
}
