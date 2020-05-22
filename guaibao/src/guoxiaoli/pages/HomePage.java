package guoxiaoli.pages;

import guoxiaoli.utils.BaseAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomePage {

	private AndroidDriver<AndroidElement> driver;
	BaseAction action;
	
	public HomePage(AndroidDriver<AndroidElement> driver){
		this.driver=driver;
		this.action=new BaseAction(driver);
	}
	
	public AndroidElement ho_img(){
		return this.driver.findElementById("img_4");
	}
	
	public AndroidElement ho_sz(){
		return this.driver.findElementByXPath("//*[@text='设置']");
	}
	
	public AndroidElement ho_intro(){
		return this.driver.findElementByXPath("//*[@text='功能介绍']");
	}
	
	public AndroidElement ho_ser(){
		return this.driver.findElementByXPath("//*[@text='软件许可及服务协议']");
	}
	
	public AndroidElement ho_ver(){
		return this.driver.findElementByXPath("//*[@text='当前版本']");
	}
	
	public AndroidElement ho_help(){
		return this.driver.findElementByXPath("//*[@text='帮助']");
	}
	
	public AndroidElement ho_lout(){
		return this.driver.findElementById("tuichu");
	}
	
	public String introduce(){
		action.click(ho_img());
		action.click(ho_sz());
		action.click(ho_intro());
		return action.getToast();
	}
	
	public String  serve(){
		action.click(ho_img());
		action.click(ho_sz());
		action.click(ho_ser());
		return action.getToast();
	}
	
	public String version(){
		action.click(ho_img());
		action.click(ho_sz());
		action.click(ho_ver());
		return action.getToast();
	}
	
	public String help(){
		action.click(ho_img());
		action.click(ho_sz());
		action.click(ho_help());
		return action.getToast();
	}
	
	public String loginout(){
		action.click(ho_img());
		action.click(ho_sz());
		action.click(ho_lout());
		return action.getToast();
	}
	
	
}
