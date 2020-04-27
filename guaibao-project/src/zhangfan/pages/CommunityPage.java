package edu.pages;

import java.util.List;

import org.openqa.selenium.By;

import edu.utils.BaseAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CommunityPage {
	private AndroidDriver<AndroidElement> driver;
	private BaseAction action;
	public CommunityPage(AndroidDriver<AndroidElement> driver){
		this.driver=driver;
		this.action=new BaseAction(driver);
	}
	
	public AndroidElement btn_community(){
		return driver.findElementById("img_3");
	}
	public AndroidElement addpost_item(){
		return driver.findElementById("community_add_post");
	}
	public AndroidElement editpost_item(){
		return driver.findElementByXPath("//*[@text='分享有趣的事...']");
	}
	public AndroidElement btn_submitpost(){
		return driver.findElementByXPath("//*[@text='发表']");
	}
	public AndroidElement btn_dianzan(){
		return driver.findElementById("community_praising");
	}
	public AndroidElement btn_comment(){
		return driver.findElementByXPath("//*[@text='评论']");
	}
	public AndroidElement editcomment_item(){
		return driver.findElementByXPath("//*[@text='想说点什么']");
	}
	public AndroidElement btn_submitcomment(){
		return driver.findElementByXPath("//*[@text='发送']");
	}
	public AndroidElement comment_item(){
		return driver.findElementById("community_comment1");
	}
	public AndroidElement commentcontent_item(){
		return driver.findElementById("comment_content");
	}
	public AndroidElement editreplycommment_item(){
		return driver.findElementById("et_input_message");
	}
	public AndroidElement btn_back_item(){
		return driver.findElementById("detail_back");
	}
	public AndroidElement btn_addpicture(){
		return driver.findElementById("iv_push_speak_img_item");
	}
	//选择第一张图片
	public  MobileElement photo_checked1() {
		AndroidElement list = driver.findElement(By.id("rvImageList"));
		List<MobileElement> items = list.findElements(By.id("ivPhotoCheaked"));
		int count = items.size();
		return items.get(0);
	}
	//选择第二张图片
	public  MobileElement photo_checked2() {		
		AndroidElement list = driver.findElement(By.id("rvImageList"));
		List<MobileElement> items = list.findElements(By.id("ivPhotoCheaked"));
		int count = items.size();
		return items.get(1);
	}
	//选择第三张图片
	public  MobileElement photo_checked3() {		
		AndroidElement list = driver.findElement(By.id("rvImageList"));
		List<MobileElement> items = list.findElements(By.id("ivPhotoCheaked"));
		int count = items.size();
		return items.get(2);
	}
	//选择第四张图片
	public  MobileElement photo_checked4() {		
		AndroidElement list = driver.findElement(By.id("rvImageList"));
		List<MobileElement> items = list.findElements(By.id("ivPhotoCheaked"));
		int count = items.size();
		return items.get(3);
	}
	//选择第五张图片
	public  MobileElement photo_checked5() {		
		AndroidElement list = driver.findElement(By.id("rvImageList"));
		List<MobileElement> items = list.findElements(By.id("ivPhotoCheaked"));
		int count = items.size();
		return items.get(4);
	}
	//选择第六张图片
	public  MobileElement photo_checked6() {		
		AndroidElement list = driver.findElement(By.id("rvImageList"));
		List<MobileElement> items = list.findElements(By.id("ivPhotoCheaked"));
		int count = items.size();
		return items.get(5);
	}
	
	public AndroidElement btn_confirm(){
		return driver.findElementById("btnConfirm");
	}
	
	
	//添加帖子
	public void addPost(String content){
		action.click(btn_community());
		action.click(addpost_item());
		action.type(editpost_item(), content);
		action.click(btn_submitpost());		
	}
	//添加带一张图片的帖子
	public void addPostWithOnePicture(){
		action.click(btn_community());
		action.click(addpost_item());
		action.click(btn_addpicture());
		action.click(photo_checked1());
		action.click(btn_confirm());
		action.click(btn_submitpost());		

	}
	//添加带有六张图片的帖子
	public void addPostWithSixPictures() throws InterruptedException{
		action.click(btn_community());
		action.click(addpost_item());
		action.click(btn_addpicture());
		action.click(photo_checked1());
		action.click(photo_checked2());
		action.click(photo_checked3());
		action.click(photo_checked4());
		action.click(photo_checked5());
		action.click(photo_checked6());
		action.click(btn_confirm());
		action.click(btn_submitpost());
		Thread.sleep(20000);

	}
	//添加带有一张图片和文字的帖子
	public void addPostWithOnePictureAndText(String text){
		action.click(btn_community());
		action.click(addpost_item());
		action.type(editpost_item(), text);
		action.click(btn_addpicture());
		action.click(photo_checked1());
		action.click(btn_confirm());
		action.click(btn_submitpost());
	}
	//添加带有六张图片和文字的帖子
	public void addPostWithSixPicturesAndText(String text) throws InterruptedException{
		action.click(btn_community());
		action.click(addpost_item());
		action.type(editpost_item(), text);
		action.click(btn_addpicture());
		action.click(photo_checked1());
		action.click(photo_checked2());
		action.click(photo_checked3());
		action.click(photo_checked4());
		action.click(photo_checked5());
		action.click(photo_checked6());
		action.click(btn_confirm());
		action.click(btn_submitpost());
		Thread.sleep(20000);
	}
	//点赞功能
	public void dianzan(){
		action.click(btn_community());
		action.click(btn_dianzan());
	}
	//评论成功
	public String commentSuccess(String commentcontent){
		action.click(btn_community());
		action.click(btn_comment());
		action.type(editcomment_item(), commentcontent);
		action.click(btn_submitcomment());
		return action.getToast();
	}
	//回复评论
	public String replyToComment(String content){
		action.click(btn_community());
		action.click(comment_item());
		action.click(commentcontent_item());
		action.type(editreplycommment_item(), content);
		action.click(btn_submitcomment());
		action.click(btn_back_item());
		return action.getToast();
	}
}
