package guoxiaoli.pages;

import guoxiaoli.utils.BaseAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ForgetPage {

	private AndroidDriver<AndroidElement> driver;
	BaseAction action;
	
	public ForgetPage(AndroidDriver<AndroidElement> driver){
		this.driver=driver;
		this.action=new BaseAction(driver);
	}
	
//	com.example.lenovo.maandroid/.Login.RegisterActivity
	public AndroidElement btn_fgpwd(){
		return this.driver.findElementById("btn_forgetPwd");
	}
	
	public AndroidElement fg_phone(){
		return this.driver.findElementById("et_phone");
	}
	
	public AndroidElement fg_yan(){
		return this.driver.findElementById("et_yanzhengma");
	}
	
	public AndroidElement fg_psd(){
		return this.driver.findElementById("et_password");
	}
	
	public AndroidElement fg_psd1(){
		return this.driver.findElementById("et_password1");
	}
	
	public AndroidElement fg_submit(){
		return this.driver.findElementById("btn_submit");
	}
	
	
	public LoginPage  feditSuccess(String phone, String yzm,String psd,String psd1) {
		action.click(btn_fgpwd());
		action.type(fg_phone(),phone);
		action.type(fg_yan(),yzm);
		action.type(fg_psd(),psd);
		action.type(fg_psd1(),psd1);
		action.click(fg_submit());
//		return action.getToast();
		return new LoginPage(driver);

	}
	
	public String  feditFail(String phone, String yzm,String psd,String psd1) {
		action.click(btn_fgpwd());
		action.type(fg_phone(),phone);
		action.type(fg_yan(),yzm);
		action.type(fg_psd(),psd);
		action.type(fg_psd1(),psd1);
		action.click(fg_submit());
		return action.getToast();

	}
	
	
	
	
}
