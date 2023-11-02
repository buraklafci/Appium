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

public class Appium04 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability("platformName","Android");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\burak\\ideaProject\\Appium\\src\\Apps\\Calculator.apk");

        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        Thread.sleep(5000);
        MobileElement num1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement num2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement num3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement num4 = driver.findElementById("com.google.android.calculator:id/digit_4");
        MobileElement num5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        MobileElement num6 = driver.findElementById("com.google.android.calculator:id/digit_6");
        MobileElement num7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        MobileElement num8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        MobileElement num9 = driver.findElementById("com.google.android.calculator:id/digit_9");
        MobileElement num0 = driver.findElementById("com.google.android.calculator:id/digit_0");

        MobileElement plus = driver.findElementByAccessibilityId("plus");
        MobileElement multiply = driver.findElementByAccessibilityId("×");
        MobileElement divide = driver.findElementByAccessibilityId("divide");
        MobileElement minus = driver.findElementByAccessibilityId("minus");

        MobileElement equal = driver.findElementByAccessibilityId("equals");


        //64+71
        num6.click();
        num4.click();
        plus.click();
        num7.click();
        num1.click();

        MobileElement preResult = driver.findElementById("com.google.android.calculator:id/result_preview");
        System.out.println("Pre result "+ preResult.getText());
        String preResultText = preResult.getText();

        equal.click();

        MobileElement result = driver.findElementById("com.google.android.calculator:id/result_final");
        System.out.println("final result " + result.getText());

        Assert.assertEquals(result.getText(),preResultText);

    }
}