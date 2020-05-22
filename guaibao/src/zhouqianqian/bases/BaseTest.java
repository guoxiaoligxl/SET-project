package zhouqianqian.bases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseTest {
	public AndroidDriver<AndroidElement> driver;
	Dimension dimension;

	//com.example.lenovo.maandroid/.Login.LoginActivity
	//com.example.lenovo.maandroid/.Host.WelcomeActivity
	//com.example.lenovo.maandroid/.Host.MainActivity
	
//	adb logcat|findstr Displayed
	
//	要求上传页面对象类、测试用例类
	@BeforeClass
	public void startUp() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "127.0.0.1:62001");
//		cap.setCapability("deviceName", "YTQNW17321063260");
		cap.setCapability("appPackage", "com.example.lenovo.maandroid");
		cap.setCapability("appActivity", ".Host.WelcomeActivity");
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		dimension = driver.manage().window().getSize();
	
	}
//	
//	@AfterClass
//	public void tearDown() {
//		driver.quit();
//	}
}
