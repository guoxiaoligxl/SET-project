package lixuan.pages;

import lixuan.pages.HomePage;
import lixuan.utils.BaseAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginPage {
	private AndroidDriver<AndroidElement> driver;
	BaseAction action;

	public LoginPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.action = new BaseAction(driver);
	}

	public AndroidElement edit_username() {
		return this.driver.findElementById("et_userPhone");
	}

	public AndroidElement edit_password() {
		return this.driver.findElementById("et_userPassword");
	}

	public AndroidElement btn_submit() {
		return this.driver.findElementById("btn_login");
	}

	public HomePage loginSuccess(String name, String password) throws InterruptedException {

		action.type(edit_username(), name);
		Thread.sleep(2000);
		action.type(edit_password(), password);
		Thread.sleep(2000);
		action.click(btn_submit());
		Thread.sleep(2000);
		return new HomePage(driver);
	}
}

