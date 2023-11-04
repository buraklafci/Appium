package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class Appium08UISelector2 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability("platformName","Android");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\burak\\ideaProject\\Appium\\src\\Apps\\apiDemos.apk");
       // capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        //capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability("noReset","true");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/"), capabilities);
      driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").index(1)").click();
      Thread.sleep(3000);
      driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/text1\").textStartsWith(\"Preference\")").click();
        Thread.sleep(3000);
      driver.findElementByAndroidUIAutomator("UiSelector().textContains(\"dependencies\")").click();
        Thread.sleep(3000);
        String isSelected=driver.findElementByAndroidUIAutomator("UiSelector().text(\"WiFi settings\")").getAttribute("enabled");
       MobileElement wifiIsSelected=driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.RelativeLayout\").index(0)");
       if(isSelected.equals("false")) {
           wifiIsSelected.click();
        } Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("UiSelector().text(\"WiFi settings\")").click();
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.EditText\")").sendKeys("Burak");
        driver.findElementByAndroidUIAutomator("UiSelector().text(\"OK\")").click();
    }
}