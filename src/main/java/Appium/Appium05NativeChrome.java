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

public class Appium05NativeChrome {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability("platformName","Android");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("noReset", "true");

        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");

        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);

        driver.get("https://www.amazon.com");

        System.out.println(driver.getContext() + "<====app acildigindaki tur");
        Thread.sleep(7000);
        MobileElement homeScreenLogo = driver.findElementByAccessibilityId("Amazon");
        Assert.assertTrue(homeScreenLogo.isDisplayed());

        System.out.println("Ana sayfadayiz");

        Thread.sleep(4000);

        MobileElement signInButton = driver.findElementByAccessibilityId("Sign in ›");
        signInButton.click();

        Thread.sleep(5000);

        MobileElement welcomeText = driver.findElementByXPath("//android.widget.TextView[@text='Welcome']");
        Assert.assertEquals(welcomeText.getText(),"Welcome");

        System.out.println("test bitt...");
        Thread.sleep(5000);
        //close session
        driver.closeApp();
    }
}