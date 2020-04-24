package edu.pages;

import edu.utils.BaseAction;
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
	
	
	
	//添加帖子
	public void addPost(String content){
		action.click(btn_community());
		action.click(addpost_item());
		action.type(editpost_item(), content);
		action.click(btn_submitpost());		
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
	//评论失败
	public String commentFail(String commentcontent){
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
