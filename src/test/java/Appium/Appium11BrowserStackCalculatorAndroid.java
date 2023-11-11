package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium11BrowserStackCalculatorAndroid {
    @Test
    public void browserStack() throws MalformedURLException, InterruptedException {
        //https://app-automate.browserstack.com/dashboard/v2/quick-start/get-started remote dan appium testi
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "burakl_atHzBi");
        caps.setCapability("browserstack.key", "SkThzh2vRLo58qBSubNS");

        // Set URL of the application under test
        caps.setCapability("app", "bs://3aaf395441a6da615d4d52290a9b70789181e9ac");

        // Specify device and os_version for testing
        caps.setCapability("device", "Samsung Galaxy S22 Ultra");
        caps.setCapability("os_version", "12.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "ApiDemo");
        caps.setCapability("build", "yeni");
        caps.setCapability("name", "api Test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);


        // Write your test case statements here
        Thread.sleep(3000);
        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        Thread.sleep(3000);

        driver.findElementByAccessibilityId("plus").click();
        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        Thread.sleep(3000);

        driver.findElementByAccessibilityId("equals").click();
        Thread.sleep(10000);

        Assert.assertEquals("10",driver.findElementById("com.google.android.calculator:id/result_final").getText());

        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();

    }
}
