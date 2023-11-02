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
import java.util.Set;

public class Appium07UISelector {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability("platformName","Android");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\burak\\ideaProject\\Appium\\src\\Apps\\gestureTool.apk");
        capabilities.setCapability("appPackage","com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");

        capabilities.setCapability("noReset","true");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
       // https://developer.android.com/reference/androidx/test/uiautomator/UiSelector asagida ki kodlar bu siteden alinir
        //resourceId ile
        // driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")").click();
//indexle
//        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").index(0)").click();
//        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"Test\")").click();
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textStartsWith(\"Add\")").click();

        Thread.sleep(5000);

        System.out.println(driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\").enabled(false)").getAttribute("enabled"));


        //session kapat

//        driver.closeApp();
    }
}