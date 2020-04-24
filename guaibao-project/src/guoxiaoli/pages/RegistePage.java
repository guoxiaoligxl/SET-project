package guoxiaoli.pages;

import guoxiaoli.pages.LoginPage;
import guoxiaoli.utils.BaseAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RegistePage {

	private AndroidDriver<AndroidElement> driver;
	BaseAction action;
	
	public RegistePage(AndroidDriver<AndroidElement> driver){
		this.driver=driver;
		this.action=new BaseAction(driver);
	}
	
//	com.example.lenovo.maandroid:id/fab
//	com.example.lenovo.maandroid/.Login.RegisterActivity
	public AndroidElement reg_fab(){
		return this.driver.findElementById("fab");
	}
	
	public AndroidElement reg_name(){
		return this.driver.findElementById("input_layout_name");
	}
	
	public AndroidElement reg_yan(){
		return this.driver.findElementById("et_yanzhengma");
	}
	
	public AndroidElement reg_psd(){
		return this.driver.findElementById("et_password");
	}
	
	public AndroidElement reg_psd1(){
		return this.driver.findElementById("et_password1");
	}
	
	public AndroidElement reg_submit(){
		return this.driver.findElementById("btn_submit");
	}
	
	public LoginPage regisSuccess(String name, String yzm,String psd,String psd1) {
		action.click(reg_fab());
		action.type(reg_name(),name);
		action.type(reg_yan(),yzm);
		action.type(reg_psd(),psd);
		action.type(reg_psd1(),psd1);
		action.click(reg_submit());
//		return action.getToast();
		return new LoginPage(driver);

	}
	
	public String  regisFail(String name, String yzm,String psd,String psd1) {
		action.click(reg_fab());
		action.type(reg_name(),name);
		action.type(reg_yan(),yzm);
		action.type(reg_psd(),psd);
		action.type(reg_psd1(),psd1);
		action.click(reg_submit());
		return action.getToast();

	}
	
	
	
}
