package zhangfan.pages;

import zhangfan.utils.BaseAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginPage {
	private AndroidDriver<AndroidElement> driver;
	private BaseAction action;
	public LoginPage(AndroidDriver<AndroidElement> driver){
		this.driver=driver;
		
		this.action=new BaseAction(driver);
	}
	public AndroidElement phonenumber_item(){
		return driver.findElementByXPath("//*[@text='手机号']");
	}
	public AndroidElement password_item(){
		return driver.findElementByXPath("//*[@text='密码']");
	}
	public AndroidElement btn_login(){
		return driver.findElementByXPath("//*[@text='Login']");
	}
	public AndroidElement btn_mine(){
		return driver.findElementById("img_4");
	}
	public AndroidElement btn_set(){
		return driver.findElementByXPath("//*[@text='设置']");
	}
	public AndroidElement btn_quit(){
		return driver.findElementByXPath("//*[@text='退出登录']");
	}
	
	
	//登录成功
	public void loginSuccess(String phonenumber,String password){
		action.type(phonenumber_item(),phonenumber);
		action.type(password_item(),password);
		action.click(btn_login());
	}
	//登录失败
	public String loginFail(String phonenumber,String password) throws InterruptedException{
		action.type(phonenumber_item(),phonenumber);
		action.type(password_item(),password);
		action.click(btn_login());
		return action.getToast();
	}
	//登录成功后退出登录
	public LoginPage quitAfterLoginSuccess(){
		action.click(btn_mine());
		action.click(btn_set());
		action.click(btn_quit());
		return new LoginPage(driver);
	}
	
}
