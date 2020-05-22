package zhouqianqian.testCase;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import zhouqianqian.bases.BaseTest;
import zhouqianqian.dataProvider.DataProviders;
import zhouqianqian.pages.PageObject;

public class TestAdd extends BaseTest {
	PageObject po;
/*
 ************* 上传 板块测试用例 *********************  4（数据驱动）+14
 */	
	
	@DataProvider(name="test_onlyTest1")
	public Object[][] createData1() throws IOException {
		DataProviders provider = new DataProviders();
	 	return provider.getDataByExcel("F:\\content.xlsx","data");
	}
		
	
	@Test(dataProvider="test_onlyTest1")
	public void test_onlyTest1(String content) throws InterruptedException{
		System.out.println(content);
		po = new PageObject(driver);
		po.addSuccess1(content);
		Thread.sleep(3000);
	}
	@Test
	public void test_onlyTest2() throws InterruptedException{
		po = new PageObject(driver);
		po.addSuccess2("hello");
		Thread.sleep(3000);
	}
	@Test
	public void test_onlyTest3() throws InterruptedException{
		po = new PageObject(driver);
		po.addSuccess3("hello");
		Thread.sleep(3000);
	}
	@Test
	public void test_onlyTest4() throws InterruptedException{
		po = new PageObject(driver);
		po.addSuccess4("hello");
		Thread.sleep(3000);
	}
	@Test
	public void test_onlyTest5() throws InterruptedException{
		po = new PageObject(driver);
		po.addSuccess5("hello");
		Thread.sleep(3000);
	}
	@Test
	public void test_onlyTest6() throws InterruptedException{
		po = new PageObject(driver);
		po.addSuccess6("hello");
		Thread.sleep(3000);
	}
	@Test
	public void test_onlyTest7() throws InterruptedException{
		po = new PageObject(driver);
		po.addSuccess7("hello");
		Thread.sleep(3000);
	}
	@Test
	public void test_onlyTest8() throws InterruptedException{
		po = new PageObject(driver);
		po.addSuccess8("hello");
		Thread.sleep(3000);
	}
	@Test
	public void test_onlyTest9() throws InterruptedException{
		po = new PageObject(driver);
		po.addSuccess9();
		Thread.sleep(3000);
	}
	@Test
	public void test_onlyTestz10() throws InterruptedException{
		po = new PageObject(driver);
		po.addSuccess10();
		Thread.sleep(3000);
	}
	@Test
	public void test_onlyTestz11() throws InterruptedException{
		po = new PageObject(driver);
		po.addSuccess11();
		Thread.sleep(3000);
	}
	@Test
	public void test_onlyTestz12() throws InterruptedException{
		po = new PageObject(driver);
		po.addSuccess12();
		Thread.sleep(3000);
	}
	
//****************Fail***********************************	
	
	@Test
	public void test_onlyTestzfail1() throws InterruptedException{
		po = new PageObject(driver);
		po.addFail1();
		Thread.sleep(3000);
	}
	@Test
	public void test_onlyTestzfail2() throws InterruptedException{
		po = new PageObject(driver);
		po.addFail2();
		Thread.sleep(3000);
	}
	@Test
	public void test_onlyTestzfail3() throws InterruptedException{
		po = new PageObject(driver);
		po.addFail3();
		Thread.sleep(3000);
	}
/*
 ************* 搜索 板块测试用例 ********************* 4
 */

//********************fail*******************************
	
	@Test
	public void test_psearch1(){
		po = new PageObject(driver);
		po.search();
	}
//********************success*******************************	
	@Test
	public void test_psearch2(){
		po = new PageObject(driver);
		po.searchByAllLabel();
	}
	@Test
	public void test_psearch3(){
		po = new PageObject(driver);
		po.searchByOneLabel();
	}
	@Test
	public void test_psearch4(){
		po = new PageObject(driver);
		po.searchByThreeLabel();
	}
	
	
/*
 ************* 获取时间列表 板块测试用例 ********************* 3
 */
	@Test
	public void test_qget1(){
		po = new PageObject(driver);
		po.getLeftTimeList();
	}
	@Test
	public void test_qget2(){
		po = new PageObject(driver);
		po.getMidTimeList();
	}
	@Test
	public void test_qget3(){
		po = new PageObject(driver);
		po.getRightTimeList();
	}
}
