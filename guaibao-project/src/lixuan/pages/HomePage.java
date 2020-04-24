package lixuan.pages;

import java.util.List;

import org.openqa.selenium.By;

import lixuan.utils.BaseAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomePage {
	private AndroidDriver<AndroidElement> driver;
	BaseAction action;
	public HomePage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		
		this.action = new BaseAction(driver);
	}
	//进入我的按钮
		private AndroidElement btn_my() {
			return driver.findElementById("tab_spec_4");
		}
	//进入修改信息的那个笔的按钮
	private AndroidElement btn_pencil() {
		return driver.findElementById("edit_m");
	}
//	//修改头像的按钮
//	private AndroidElement btn_img() {
//		return driver.findElementById("edit_btn_img");
//	}
	
	//修改昵称
	private AndroidElement nicheng() {
		return driver.findElementById("edit_username");
	}

	//编辑个人信息中的完成按钮
	private AndroidElement btn_submit() {
		return driver.findElementByXPath("//*[@text='完成']");
	}
	
	//消息通知按钮
	private AndroidElement btn_xiaoxi() {
		return driver.findElementByXPath("//*[@text='消息通知']");
	}
	//帖子管理按钮
	private AndroidElement btn_tiezi() {
		return driver.findElementByXPath("//*[@text='帖子管理']");
	}
	
	//帖子管理和帖子详细中的评论按钮
	private AndroidElement tiezi_comment() {
		return driver.findElementByXPath("//*[@text='评论']");
	}
	//帖子管理和帖子详细写评论
	private AndroidElement write_comment() {
		return driver.findElementById("et_input_message");
	}
	//帖子管理和帖子评论写好评论以后的发送按钮
	private AndroidElement btn_OK() {
		return driver.findElementByXPath("//*[@text='发送']");
	}
		
	//帖子详细按钮
	private AndroidElement btn_tiezixiangxi(){
		return driver.findElementById("community_content");
	}
	
	//孩子管理按钮
	private AndroidElement btn_child() {
		return driver.findElementByXPath("//*[@text='孩子管理']");
	}
	//添加孩子按钮
	private AndroidElement add_child() {
		return driver.findElementByXPath("//*[@text='添加孩子']");
	}
//	//添加或修改信息按钮-头像
//	private AndroidElement add_childphoto() {
//		return driver.findElementById("child_img");
//	}
	//添加或修改信息按钮-昵称
	private AndroidElement add_childnicheng() {
		return driver.findElementById("child_nickname");
	}
	//添加或修改信息按钮-生日-年
	private AndroidElement add_childbirthyear() {
		return driver.findElementById("child_years");
	}
	//添加或修改信息按钮-生日-月
	private AndroidElement add_childbirthmonth() {
		return driver.findElementById("child_month");
	}
	//添加或修改信息按钮-生日-日
	private AndroidElement add_childbirthday() {
		return driver.findElementById("child_day");
	}
	//添加或修改信息按钮-生日-日
	private AndroidElement add_ok() {
		return driver.findElementByXPath("//*[@text='完成']");
	}
	
	//删除孩子-进入删除界面按钮
	private  MobileElement list_item() {
				
		AndroidElement list = driver.findElement(By.id("com.example.lenovo.maandroid:id/list_my_child"));
		List<MobileElement> items = list.findElements(By.className("android.widget.LinearLayout"));
//		int count = items.size();
		return items.get(0);
	}
	//删除孩子-垃圾箱
	private AndroidElement delete_child() {
		return driver.findElementById("btn_de");
	}
	//确定删除孩子
	private AndroidElement delete_ok() {
		return driver.findElementByXPath("//*[@text='确定']");
	}
	//取消删除孩子
	private AndroidElement delete_no() {
		return driver.findElementByXPath("//*[@text='取消']");
	}
//	//选择图片第一步
//	private AndroidElement xuanze_photo1() {
//		return driver.findElementById("dreamway_folder_cover_left");
//	}
//	//选择图片第二步
//	private AndroidElement xuanze_photo2() {
//		return driver.findElementById("gl_root_view");
//	}
	
	//设置按钮
	private AndroidElement btn_shezhi() {
		return driver.findElementByXPath("//*[@text='设置']");
	}
	//退出登录按钮
	private AndroidElement btn_byby() {
		return driver.findElementByXPath("//*[@text='退出登录']");
	}
	//编辑个人信息返回键\消息通知返回键\我的孩子返回键
	private AndroidElement fanhui_message() {
		return driver.findElementById("return0");
	}
	//我的帖子返回键
	private AndroidElement fanhui_my() {
		return driver.findElementById("return2");
	}
	//帖子详细返回键
	private AndroidElement fanhui_detail() {
		return driver.findElementById("detail_back");
	}
	//添加或修改信息返回键
	private AndroidElement fanhuiedit_child() {
		return driver.findElementById("child_fanhui");
	}
	public void byby() throws InterruptedException{
		Thread.sleep(2000);
		action.click(btn_shezhi());
		Thread.sleep(2000);
		action.click(btn_byby());
	}
//	//1编辑信息头像
//	public void editmessage_photo() {
//		action.click(btn_my());
//		action.click(btn_pencil());
//		action.click(btn_img());
//		action.click(xuanze_photo1());
//		action.click(xuanze_photo2());
//		
//		action.click(btn_submit());
//		action.click(fanhui_message());		
//	}
	//1编辑信息昵称
	public void editmessage_nickname(String content) throws InterruptedException {
		action.click(btn_my());
		Thread.sleep(1000);
		action.click(btn_pencil());
		Thread.sleep(1000);
		action.type(nicheng(),content);
		action.click(btn_submit());
		System.out.println(action.getToast());
		action.click(fanhui_message());	
		Thread.sleep(1000);
	}	
	//2查看消息通知
	public void invitationItem() throws InterruptedException {
		action.click(btn_my());
		Thread.sleep(1000);
		action.click(btn_xiaoxi());		
		Thread.sleep(1000);
		action.click(fanhui_message());		
	}
	//3、4查看帖子管理和帖子详细
	public void invitation_tiezi() throws InterruptedException {
		action.click(btn_my());
		Thread.sleep(1000);
		action.click(btn_tiezi());
		Thread.sleep(1000);
		action.click(btn_tiezixiangxi());
		Thread.sleep(1000);
		action.click(fanhui_detail());
		Thread.sleep(1000);
		action.click(fanhui_my());		
	}
	//5、6、7、8帖子管理界面评论(数据驱动)
	public void invi_comment(String content) throws InterruptedException {
		action.click(btn_my());
		Thread.sleep(1000);
		action.click(btn_tiezi());	
		Thread.sleep(1000);
		action.click(tiezi_comment());
		Thread.sleep(1000);
		action.type(write_comment(),content);
		Thread.sleep(1000);
		action.click(btn_OK());
		System.out.println(action.getToast());
		Thread.sleep(1000);
		action.click(fanhui_my());		
	}
	//9、10、11、12帖子详细界面评论(数据驱动)
	public void invidetail_comment(String content) throws InterruptedException {
		action.click(btn_my());
		Thread.sleep(1000);
		action.click(btn_tiezi());	
		Thread.sleep(1000);
		action.click(btn_tiezixiangxi());
		Thread.sleep(1000);
		action.click(tiezi_comment());
		Thread.sleep(1000);
		action.type(write_comment(),content);
		Thread.sleep(1000);
		action.click(btn_OK());
		System.out.println(action.getToast());
		Thread.sleep(1000);
		action.click(fanhui_detail());
		Thread.sleep(1000);
		action.click(fanhui_my());		
	}
	//13、14、15、16、17、18、19、20、21添加孩子(数据驱动)
	public void add_childrensuccess(String nickname,String year,String month,String day) throws InterruptedException{
		Thread.sleep(1000);
		action.click(btn_my());
		Thread.sleep(1000);
		action.click(btn_child());
		Thread.sleep(1000);
		action.click(add_child());
		Thread.sleep(1000);
		action.type(add_childnicheng(),nickname);
		Thread.sleep(1000);
		action.type(add_childbirthyear(),year);
		Thread.sleep(1000);
		action.type(add_childbirthmonth(),month);
		Thread.sleep(1000);
		action.type(add_childbirthday(),day);
		Thread.sleep(1000);
		action.click(add_ok());
//		action.click(fanhuiedit_child());
		action.click(fanhui_message());
	}
	public void add_childrenfail(String nickname,String year,String month,String day) throws InterruptedException{
		Thread.sleep(1000);
		action.click(btn_my());
		Thread.sleep(1000);
		action.click(btn_child());
		Thread.sleep(1000);
		action.click(add_child());
		Thread.sleep(1000);
		action.type(add_childnicheng(),nickname);
		Thread.sleep(1000);
		action.type(add_childbirthyear(),year);
		Thread.sleep(1000);
		action.type(add_childbirthmonth(),month);
		Thread.sleep(1000);
		action.type(add_childbirthday(),day);
		Thread.sleep(1000);
		action.click(add_ok());
		System.out.println(action.getToast());
		Thread.sleep(1000);
		action.click(fanhuiedit_child());
		action.click(fanhui_message());
	}
	//22修改第一个孩子的昵称
	public void edit_nickname(String nickname) throws InterruptedException{
		Thread.sleep(1000);
		action.click(btn_my());
		Thread.sleep(1000);
		action.click(btn_child());
		Thread.sleep(1000);
		action.click(list_item());
		Thread.sleep(2000);
		action.type(add_childnicheng(),nickname);
		Thread.sleep(1000);
		action.click(add_ok());
		action.click(fanhui_message());
	}
	//23修改第一个孩子的生日
	public void edit_birthday(String year,String month,String day) throws InterruptedException{
		action.click(btn_my());
		Thread.sleep(1000);
		action.click(btn_child());
		Thread.sleep(1000);
		action.click(list_item());
		Thread.sleep(2000);
		action.type(add_childbirthyear(),year);
		Thread.sleep(1000);
		action.type(add_childbirthmonth(),month);
		Thread.sleep(1000);
		action.type(add_childbirthday(),day);
		Thread.sleep(1000);
		action.click(add_ok());
		action.click(fanhui_message());
	}
	//24删除孩子-确定删除
	public void delete_childrenok() throws InterruptedException{
		action.click(btn_my());
		Thread.sleep(1000);
		action.click(btn_child());
		Thread.sleep(1000);
		action.click(list_item());
		Thread.sleep(2000);
		action.click(delete_child());
		Thread.sleep(1000);
		action.click(delete_ok());
		action.click(fanhui_message());
	}
	//25删除孩子-取消删除
	public void delete_childrenno() throws InterruptedException{
		action.click(btn_my());
		Thread.sleep(1000);
		action.click(btn_child());
		Thread.sleep(1000);
		action.click(list_item());
		Thread.sleep(2000);
		action.click(delete_child());
		Thread.sleep(1000);
		action.click(delete_no());
		action.click(fanhuiedit_child());
		action.click(fanhui_message());
	}
}

