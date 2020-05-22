package guoxiaoli.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseTest {

	URL url;
	public AndroidDriver<AndroidElement> driver;
	Dimension dimension;

	@BeforeClass
	public void startUp() throws MalformedURLException{
		url=new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "4YY4C17801001437");
//		cap.setCapability("deviceName", "ff3eb2f3");
//		.Login.LoginActivity-.Host.WelcomeActivity-.Host.MainActivity
		cap.setCapability("appPackage","com.example.lenovo.maandroid");
		cap.setCapability("appActivity", ".Host.WelcomeActivity");
		cap.setCapability("noReset","true");
		
		driver=new AndroidDriver<AndroidElement>(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dimension=driver.manage().window().getSize();
	}
	
//	@AfterClass
//	public void tearDown(){
//		driver.quit();
//	}
}
