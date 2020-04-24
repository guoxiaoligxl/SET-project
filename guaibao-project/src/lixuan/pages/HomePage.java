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
	//�����ҵİ�ť
		private AndroidElement btn_my() {
			return driver.findElementById("tab_spec_4");
		}
	//�����޸���Ϣ���Ǹ��ʵİ�ť
	private AndroidElement btn_pencil() {
		return driver.findElementById("edit_m");
	}
//	//�޸�ͷ��İ�ť
//	private AndroidElement btn_img() {
//		return driver.findElementById("edit_btn_img");
//	}
	
	//�޸��ǳ�
	private AndroidElement nicheng() {
		return driver.findElementById("edit_username");
	}

	//�༭������Ϣ�е���ɰ�ť
	private AndroidElement btn_submit() {
		return driver.findElementByXPath("//*[@text='���']");
	}
	
	//��Ϣ֪ͨ��ť
	private AndroidElement btn_xiaoxi() {
		return driver.findElementByXPath("//*[@text='��Ϣ֪ͨ']");
	}
	//���ӹ���ť
	private AndroidElement btn_tiezi() {
		return driver.findElementByXPath("//*[@text='���ӹ���']");
	}
	
	//���ӹ����������ϸ�е����۰�ť
	private AndroidElement tiezi_comment() {
		return driver.findElementByXPath("//*[@text='����']");
	}
	//���ӹ����������ϸд����
	private AndroidElement write_comment() {
		return driver.findElementById("et_input_message");
	}
	//���ӹ������������д�������Ժ�ķ��Ͱ�ť
	private AndroidElement btn_OK() {
		return driver.findElementByXPath("//*[@text='����']");
	}
		
	//������ϸ��ť
	private AndroidElement btn_tiezixiangxi(){
		return driver.findElementById("community_content");
	}
	
	//���ӹ���ť
	private AndroidElement btn_child() {
		return driver.findElementByXPath("//*[@text='���ӹ���']");
	}
	//��Ӻ��Ӱ�ť
	private AndroidElement add_child() {
		return driver.findElementByXPath("//*[@text='��Ӻ���']");
	}
//	//��ӻ��޸���Ϣ��ť-ͷ��
//	private AndroidElement add_childphoto() {
//		return driver.findElementById("child_img");
//	}
	//��ӻ��޸���Ϣ��ť-�ǳ�
	private AndroidElement add_childnicheng() {
		return driver.findElementById("child_nickname");
	}
	//��ӻ��޸���Ϣ��ť-����-��
	private AndroidElement add_childbirthyear() {
		return driver.findElementById("child_years");
	}
	//��ӻ��޸���Ϣ��ť-����-��
	private AndroidElement add_childbirthmonth() {
		return driver.findElementById("child_month");
	}
	//��ӻ��޸���Ϣ��ť-����-��
	private AndroidElement add_childbirthday() {
		return driver.findElementById("child_day");
	}
	//��ӻ��޸���Ϣ��ť-����-��
	private AndroidElement add_ok() {
		return driver.findElementByXPath("//*[@text='���']");
	}
	
	//ɾ������-����ɾ�����水ť
	private  MobileElement list_item() {
				
		AndroidElement list = driver.findElement(By.id("com.example.lenovo.maandroid:id/list_my_child"));
		List<MobileElement> items = list.findElements(By.className("android.widget.LinearLayout"));
//		int count = items.size();
		return items.get(0);
	}
	//ɾ������-������
	private AndroidElement delete_child() {
		return driver.findElementById("btn_de");
	}
	//ȷ��ɾ������
	private AndroidElement delete_ok() {
		return driver.findElementByXPath("//*[@text='ȷ��']");
	}
	//ȡ��ɾ������
	private AndroidElement delete_no() {
		return driver.findElementByXPath("//*[@text='ȡ��']");
	}
//	//ѡ��ͼƬ��һ��
//	private AndroidElement xuanze_photo1() {
//		return driver.findElementById("dreamway_folder_cover_left");
//	}
//	//ѡ��ͼƬ�ڶ���
//	private AndroidElement xuanze_photo2() {
//		return driver.findElementById("gl_root_view");
//	}
	
	//���ð�ť
	private AndroidElement btn_shezhi() {
		return driver.findElementByXPath("//*[@text='����']");
	}
	//�˳���¼��ť
	private AndroidElement btn_byby() {
		return driver.findElementByXPath("//*[@text='�˳���¼']");
	}
	//�༭������Ϣ���ؼ�\��Ϣ֪ͨ���ؼ�\�ҵĺ��ӷ��ؼ�
	private AndroidElement fanhui_message() {
		return driver.findElementById("return0");
	}
	//�ҵ����ӷ��ؼ�
	private AndroidElement fanhui_my() {
		return driver.findElementById("return2");
	}
	//������ϸ���ؼ�
	private AndroidElement fanhui_detail() {
		return driver.findElementById("detail_back");
	}
	//��ӻ��޸���Ϣ���ؼ�
	private AndroidElement fanhuiedit_child() {
		return driver.findElementById("child_fanhui");
	}
	public void byby() throws InterruptedException{
		Thread.sleep(2000);
		action.click(btn_shezhi());
		Thread.sleep(2000);
		action.click(btn_byby());
	}
//	//1�༭��Ϣͷ��
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
	//1�༭��Ϣ�ǳ�
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
	//2�鿴��Ϣ֪ͨ
	public void invitationItem() throws InterruptedException {
		action.click(btn_my());
		Thread.sleep(1000);
		action.click(btn_xiaoxi());		
		Thread.sleep(1000);
		action.click(fanhui_message());		
	}
	//3��4�鿴���ӹ����������ϸ
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
	//5��6��7��8���ӹ����������(��������)
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
	//9��10��11��12������ϸ��������(��������)
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
	//13��14��15��16��17��18��19��20��21��Ӻ���(��������)
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
	//22�޸ĵ�һ�����ӵ��ǳ�
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
	//23�޸ĵ�һ�����ӵ�����
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
	//24ɾ������-ȷ��ɾ��
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
	//25ɾ������-ȡ��ɾ��
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

