package lixuan.base;

import java.awt.Dimension;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseTest {
	URL url;
    protected AndroidDriver<AndroidElement> driver;
	org.openqa.selenium.Dimension dimension;

	@BeforeClass
	public void startUp() throws MalformedURLException, InterruptedException {
		url = new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName","Android");
		cap.setCapability("deviceName","bc9111f");
		cap.setCapability("appPackage","com.example.lenovo.maandroid");
		cap.setCapability("appActivity",".Host.WelcomeActivity");
		cap.setCapability("noReset","true");
		driver = new AndroidDriver<AndroidElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		dimension = driver.manage().window().getSize();
	
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
