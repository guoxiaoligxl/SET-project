package zhouqianqian.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import zhouqianqian.utils.BaseAction;

public class PageObject {
	private AndroidDriver<AndroidElement> driver;
	BaseAction action;
	
	
	public PageObject(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.action = new BaseAction(driver);
	}
/*
 ************* po 元素查找 *********************
 */
	
	/**
	 * 成长记录
	 */
	public AndroidElement record_growth() {
//		com.example.lenovomaandroid:id/img_2
		return this.driver.findElementById("img_2");
	}
	/**
	 * 左日期
	 */
	public AndroidElement left_time() {
//		com.example.lenovo.maandroid:id/image
		return this.driver.findElementsById("image").get(0);
//		return this.driver.findElementById("image");
	}
	/**
	 * 中日期
	 */
	public AndroidElement mid_time() {
//		return this.driver.findElementById("image");
		return this.driver.findElementsById("image").get(1);
	}
	/**
	 * 右日期
	 */
	public AndroidElement right_time() {
//		return this.driver.findElementById("image");
		return this.driver.findElementsById("image").get(2);
	}
	/**
	 * 添加记录
	 */
	public AndroidElement record_add() {
//		com.example.lenovo.maandroid:id/add
		return this.driver.findElementById("add");
	}
	/**
	 * 搜索记录
	 */
	public AndroidElement record_search() {
//		com.example.lenovo.maandroid:id/look
		return this.driver.findElementById("look");
	}
	/**
	 * 编辑文字
	 */
	public AndroidElement text_edit() {
//		com.example.lenovo.maandroid:id/et_content
		return this.driver.findElementById("et_content");
	}
	
	/**
	 * 添加图片
	 */
	public AndroidElement photo_add() {
//		com.example.lenovo.maandroid:id/add_picture
		return this.driver.findElementById("add_picture");
	}
	/**
	 * 选中第一张图片
	 */
	public  MobileElement photo_checked1() {	
//		com.example.lenovo.maandroid:id/rvImageList
//		com.example.lenovo.maandroid:id/ivPhotoCheaked
		AndroidElement list = driver.findElement(By.id("rvImageList"));
		List<MobileElement> items = list.findElements(By.id("ivPhotoCheaked"));
		int count = items.size();
		return items.get(0);
	}
	/**
	 * 选中第二张图片
	 */
	public  MobileElement photo_checked2() {		
//		com.example.lenovo.maandroid:id/ivPhotoCheaked
		AndroidElement list = driver.findElement(By.id("rvImageList"));
		List<MobileElement> items = list.findElements(By.id("ivPhotoCheaked"));
		int count = items.size();
		return items.get(1);
	}
	/**
	 * 选中第三张图片
	 */
	public  MobileElement photo_checked3() {		
//		com.example.lenovo.maandroid:id/ivPhotoCheaked
		AndroidElement list = driver.findElement(By.id("rvImageList"));
		List<MobileElement> items = list.findElements(By.id("ivPhotoCheaked"));
		int count = items.size();
		return items.get(2);
	}
	/**
	 * 选中第四张图片
	 */
	public  MobileElement photo_checked4() {		
//		com.example.lenovo.maandroid:id/ivPhotoCheaked
		AndroidElement list = driver.findElement(By.id("rvImageList"));
		List<MobileElement> items = list.findElements(By.id("ivPhotoCheaked"));
		int count = items.size();
		return items.get(3);
	}
	/**
	 * 选中第五张图片
	 */
	public  MobileElement photo_checked5() {		
//		com.example.lenovo.maandroid:id/ivPhotoCheaked
		AndroidElement list = driver.findElement(By.id("rvImageList"));
		List<MobileElement> items = list.findElements(By.id("ivPhotoCheaked"));
		int count = items.size();
		return items.get(4);
	}
	/**
	 * 选中第六张图片
	 */
	public  MobileElement photo_checked6() {		
//		com.example.lenovo.maandroid:id/ivPhotoCheaked
		AndroidElement list = driver.findElement(By.id("rvImageList"));
		List<MobileElement> items = list.findElements(By.id("ivPhotoCheaked"));
		int count = items.size();
		return items.get(5);
	}
	/**
	 * 添加图片
	 */
	public AndroidElement confirm_btn() {
//		com.example.lenovo.maandroid:id/btnConfirm
		return this.driver.findElementById("btnConfirm");
	}
	/**
	 * 添加标签（生日）
	 */
	public AndroidElement label_birth() {
		return this.driver.findElementByXPath("//*[@text='生日']");
	}
	/**
	 * 添加标签（比赛）
	 */
	public AndroidElement label_compete() {
		return this.driver.findElementByXPath("//*[@text='比赛']");
	}
	/**
	 * 添加标签（游戏）
	 */
	public AndroidElement label_game() {
		return this.driver.findElementByXPath("//*[@text='游戏']");
	}
	/**
	 * 添加标签（旅游）
	 */
	public AndroidElement label_travel() {
		return this.driver.findElementByXPath("//*[@text='旅游']");
	}
	/**
	 * 添加标签（互动）
	 */
	public AndroidElement label_mutual() {
		return this.driver.findElementByXPath("//*[@text='互动']");
	}
	/**
	 * 添加标签（成长）
	 */
	public AndroidElement label_growth() {
		return this.driver.findElementByXPath("//*[@text='成长']");
	}
	/**
	 * 添加标签（陪伴）
	 */
	public AndroidElement label_company() {
		return this.driver.findElementByXPath("//*[@text='陪伴']");
	}
	/**
	 * 添加标签（捣蛋）
	 */
	public AndroidElement label_play() {
		return this.driver.findElementByXPath("//*[@text='捣蛋']");
	}
	/**
	 * 添加标签（日常）
	 */
	public AndroidElement label_general() {
		return this.driver.findElementByXPath("//*[@text='日常']");
	}
	/**
	 * 上传
	 */
	public AndroidElement send_btn() {
		return this.driver.findElementByXPath("//*[@text='上传']");
	}
	/**
	 * 搜索
	 */
	public AndroidElement search_btn() {
		return this.driver.findElementByXPath("//*[@text='搜索']");
	}
	
	

/*
 ************* 上传 板块测试用例 *********************  4（数据驱动）+14
 */
	
	//只添加一段文字（数字、特殊字符，英文，汉字，混合文字）（数据驱动）
	public void addSuccess1(String content){
		action.click(record_growth());
		action.click(record_add());
		action.type(text_edit(), content);
		action.click(send_btn());
	}
	//添加一段文字+一张图片
		public void addSuccess2(String content) throws InterruptedException{
			action.click(record_growth());
			action.click(record_add());
			action.type(text_edit(), content);
			action.click(photo_add());
			Thread.sleep(2000);
			action.click(photo_checked1());//选中一张照片
			action.click(confirm_btn());//点击确定
			action.click(send_btn());
		}
		//添加一段文字+六张图片
		public void addSuccess3(String content){
			action.click(record_growth());
			action.click(record_add());
			action.type(text_edit(), content);
			action.click(photo_add());
			action.click(photo_checked1());//选中照片
			action.click(photo_checked2());
			action.click(photo_checked3());
			action.click(photo_checked4());
			action.click(photo_checked5());
			action.click(photo_checked6());
			action.click(confirm_btn());//点击确定
			action.click(send_btn());
		}
		//添加一段文字+一张图片+一个标签
		public void addSuccess4(String content) throws InterruptedException{
			action.click(record_growth());
			action.click(record_add());
			action.type(text_edit(), content);
			action.click(photo_add());
			action.click(photo_checked1());//选中一张照片
			action.click(confirm_btn());//点击确定
			Thread.sleep(2000);
			action.click(label_birth());//选中一个标签
			action.click(send_btn());
		}
		//添加一段文字+六张图片+一个标签
		public void addSuccess5(String content){
			action.click(record_growth());
			action.click(record_add());
			action.type(text_edit(), content);
			action.click(photo_add());
			action.click(photo_checked1());//选中照片
			action.click(photo_checked2());
			action.click(photo_checked3());
			action.click(photo_checked4());
			action.click(photo_checked5());
			action.click(photo_checked6());
			action.click(confirm_btn());//点击确定
			//选中一个标签
			action.click(label_birth());
			action.click(send_btn());
		}
		//添加一段文字+六张图片+九个标签
		public void addSuccess6(String content) throws InterruptedException{
			action.click(record_add());
			action.click(record_growth());
			action.type(text_edit(), content);
			action.click(photo_add());
			action.click(photo_checked1());//选中照片
			action.click(photo_checked2());
			action.click(photo_checked3());
			action.click(photo_checked4());
			action.click(photo_checked5());
			action.click(photo_checked6());
			action.click(confirm_btn());//点击确定
			Thread.sleep(2000);
			//选中全部标签
			action.click(label_birth());
			action.click(label_company());
			action.click(label_compete());
			action.click(label_game());
			action.click(label_general());
			action.click(label_growth());
			action.click(label_mutual());
			action.click(label_play());
			action.click(label_travel());	
			action.click(send_btn());
		}
//		添加一段文字+一个标签
		public void addSuccess7(String content){
			action.click(record_growth());
			action.click(record_add());
			action.type(text_edit(), content);
			//选中一个标签
			action.click(label_birth());
			action.click(send_btn());
		}
		//添加一段文字+九个标签
		public void addSuccess8(String content){
			action.click(record_growth());
			action.click(record_add());
			action.type(text_edit(), content);
			//选中全部标签
			action.click(label_birth());
			action.click(label_company());
			action.click(label_compete());
			action.click(label_game());
			action.click(label_general());
			action.click(label_growth());
			action.click(label_mutual());
			action.click(label_play());
			action.click(label_travel());	
			action.click(send_btn());
		}
//		添加一个图片+一个标签
		public void addSuccess9() throws InterruptedException{
			action.click(record_growth());
			action.click(record_add());
			action.click(photo_add());
			action.click(photo_checked1());//选中一张照片
			Thread.sleep(2000);
			action.click(confirm_btn());//点击确定
			action.click(label_birth());
			action.click(send_btn());
		}
		//添加六个图片+九个标签
		public void addSuccess10() throws InterruptedException{
			action.click(record_growth());
			action.click(record_add());
			action.click(photo_add());
			action.click(photo_checked1());//选中照片
			action.click(photo_checked2());
			action.click(photo_checked3());
			action.click(photo_checked4());
			action.click(photo_checked5());
			action.click(photo_checked6());
			action.click(confirm_btn());//点击确定
			Thread.sleep(2000);
			//选中全部标签
			action.click(label_birth());
			action.click(label_company());
			action.click(label_compete());
			action.click(label_game());
			action.click(label_general());
			action.click(label_growth());
			action.click(label_mutual());
			action.click(label_play());
			action.click(label_travel());	
			action.click(send_btn());
		}
		//添加六个图片
		public void addSuccess11(){
			action.click(record_growth());
			action.click(record_add());
			action.click(photo_add());
			action.click(photo_checked1());//选中照片
			action.click(photo_checked2());
			action.click(photo_checked3());
			action.click(photo_checked4());
			action.click(photo_checked5());
			action.click(photo_checked6());
			action.click(confirm_btn());//点击确定
			action.click(send_btn());
		}
		//添加一个图片
		public void addSuccess12(){
			action.click(record_growth());
			action.click(record_add());
			action.click(photo_add());
			action.click(photo_checked1());//选中一张照片
			action.click(confirm_btn());//点击确定
			action.click(send_btn());
		}
//		直接点击上传  （预期结果失败）
		public void addFail1(){
			action.click(record_growth());
			action.click(record_add());
			action.click(send_btn());
		}
//		选中一个标签直接上传  （预期结果失败）
		public void addFail2(){
			action.click(record_growth());
			action.click(record_add());
			//选中一个标签
			action.click(label_play());
			action.click(send_btn());
		}
//		选中全部标签上传  （预期结果失败）
		public void addFail3(){
			action.click(record_growth());
			action.click(record_add());
			//选中全部标签
			action.click(label_birth());
			action.click(label_company());
			action.click(label_compete());
			action.click(label_game());
			action.click(label_general());
			action.click(label_growth());
			action.click(label_mutual());
			action.click(label_play());
			action.click(label_travel());	
			action.click(send_btn());
		}
		
/*
 ************* 搜索 板块测试用例 ********************* 4
 */
		
//		直接搜索（失败，提示选择搜索条件）
		public void search(){
			action.click(record_growth());
			action.click(record_search());
			action.click(search_btn());
		}
//		选择一个标签进行搜索
		public void searchByOneLabel(){
			action.click(record_growth());
			action.click(record_search());
//			选中一个标签
			action.click(label_birth());
			action.click(search_btn());
		}
		
//		选择三个标签进行搜索
		public void searchByThreeLabel(){
			action.click(record_growth());
			action.click(record_search());
//			选中一个标签
			action.click(label_birth());
			action.click(label_general());
			action.click(label_growth());
			action.click(search_btn());
		}
		
//		选择全部标签进行搜索
		public void searchByAllLabel(){
			action.click(record_growth());
			action.click(record_search());
//			选中全部标签
			action.click(label_birth());
			action.click(label_company());
			action.click(label_compete());
			action.click(label_game());
			action.click(label_general());
			action.click(label_growth());
			action.click(label_mutual());
			action.click(label_play());
			action.click(label_travel());
			action.click(search_btn());
		}
		
/*
 ************* 获取时间列表 板块测试用例 ********************* 3
 */
		
//		左
		public void getLeftTimeList(){
			action.click(record_growth());
			action.click(left_time());
		}
//		中
		public void getMidTimeList(){
			action.click(record_growth());
			action.click(mid_time());
		}
//		右
		public void getRightTimeList(){
			action.click(record_growth());
			action.click(right_time());
		}
}
