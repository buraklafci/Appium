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

public class Appium06WebAppChrome {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability("platformName","Android");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
       // capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60000");
        //chrome driver versiyonunuzu burdan indirebilrisiniz
        //https://chromedriver.storage.googleapis.com/index.html
        //sonrasinda driver in absolute path bir alt satirda tanimliyorsunuz
       capabilities.setCapability("chromedriverExecutable","C:\\Users\\burak\\ideaProject\\Appium\\src\\driver\\chromedriver.exe");
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/"), capabilities);

        driver.get("https://www.amazon.com");

        System.out.println(driver.getContext() + "<====app acildigindaki tur");
        //burda aplikasyonun hangi turleri oldugunu gorem icin getContextHandles() kullaniyoruz.
        Set<String> butunturler = driver.getContextHandles();
        for (String tur: butunturler) {
            System.out.println(tur);
            if (tur.contains("WEBVIEW_chrome")) {
                driver.context(tur);
            }
        }

        System.out.println(driver.getContext() + "<====app sonraki durumu");

        MobileElement logo = driver.findElementByXPath("//a[@id='nav-logo-sprites']");
        Assert.assertTrue(logo.isEnabled());
        System.out.println("Ana sayfadayiz....");
        Thread.sleep(7000);

        MobileElement signInButton = driver.findElementByXPath("//a[@id='nav-logobar-greeting']");
        signInButton.click();
        Thread.sleep(7000);

        MobileElement signInTitle = driver.findElementByXPath("//h2");
        Assert.assertTrue(signInTitle.isDisplayed());
        System.out.println("Sign in sayfasindayiz");

        Thread.sleep(20000);
        //close session
        driver.closeApp();
    }
}