package edu.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseTest {
	public AndroidDriver<AndroidElement> driver;
	URL url;
	Dimension dimension;
	@BeforeClass
	public void setUp() throws MalformedURLException{
		url=new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName","Android" );
		cap.setCapability("deviceName","66J5T19819008630");
		cap.setCapability("appPackage","com.example.lenovo.maandroid");
		cap.setCapability("appActivity",".Host.WelcomeActivity");
		cap.setCapability("noReset", "true");
		driver=new AndroidDriver<AndroidElement>(url,cap);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		dimension=driver.manage().window().getSize();
	}
}
