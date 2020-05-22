package guoxiaoli.pages;

import guoxiaoli.utils.BaseAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginPage {

	private AndroidDriver<AndroidElement> driver;
	BaseAction action;
	
	public LoginPage(AndroidDriver<AndroidElement> driver){
		this.driver=driver;
		this.action=new BaseAction(driver);
	}
	
//	com.example.lenovo.maandroid/.Login.LoginActivity
	public AndroidElement et_Phone(){
		return this.driver.findElementById("et_userPhone");
	}
	
	
	public AndroidElement et_Password(){
		return this.driver.findElementById("et_userPassword");
	}
	
	public AndroidElement bt_login(){
		return this.driver.findElementById("btn_login");
	}
	
	public HomePage  loginSuccess(String phone, String password) throws InterruptedException {

		action.type(et_Phone(), phone);
		action.type(et_Password(), password);
		action.click(bt_login());
		Thread.sleep(5000);
//		return action.getToast();
		return new HomePage(driver);

	}
	
	public String  loginFail(String phone, String password) throws InterruptedException {

		action.type(et_Phone(), phone);
		action.type(et_Password(), password);
		action.click(bt_login());
		Thread.sleep(5000);
		System.out.println(action.getToast1());
		return action.getToast1();

	}
	
}
