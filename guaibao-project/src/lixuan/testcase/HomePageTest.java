package lixuan.testcase;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lixuan.base.BaseTest;
import lixuan.dataprovider.ExcelDataProvider;
import lixuan.pages.HomePage;
import lixuan.pages.LoginPage;

public class HomePageTest extends BaseTest{
	HomePage homePage;
	@BeforeMethod
	public void login() throws InterruptedException {
		LoginPage loginPage=new LoginPage(driver);
		 homePage=loginPage.loginSuccess("18831187221", "chenmeng520");
		 Thread.sleep(2000);
	}
//	//修改头像1
//	@Test
//	public void edit_photo() {
//		homePage.editmessage_photo();
//		homePage.byby();
//	}
	//修改昵称1
	@Test(priority=1)
	public void edit_nickname() throws InterruptedException{
		homePage.editmessage_nickname("小猛猛");
		homePage.byby();
		Thread.sleep(2000);
	}
	//查看消息通知2
	@Test(priority=2)
	public void invitationItem_test() throws InterruptedException{
		homePage.invitationItem();
		homePage.byby();
		Thread.sleep(2000);
	}
	//查看帖子管理和帖子详细3、4
	@Test(priority=3)
	public void invitation_test() throws InterruptedException{
		homePage.invitation_tiezi();
		homePage.byby();
		Thread.sleep(2000);
	}
	//帖子管理界面评论（数据驱动）5、6、7、8
	 @DataProvider(name="test1")
	 public Object[][] createData1() throws IOException{
		 ExcelDataProvider provider = new ExcelDataProvider();
		 return provider.getTestDataByExcel("E:\\shixun.xlsx","comment1");
	 }
	@Test(priority=4,dataProvider="test1")
	public void invitation_comment(String invicomment) throws InterruptedException{
		homePage.invi_comment(invicomment);
		homePage.byby();
		Thread.sleep(2000);
	}
	//帖子详细界面评论（数据驱动）9、10、11、12
	@DataProvider(name="test2")
	 public Object[][] createData2() throws IOException{
		 ExcelDataProvider provider = new ExcelDataProvider();
		 return provider.getTestDataByExcel("E:\\shixun.xlsx","comment2");
	 }
	@Test(priority=5,dataProvider="test2")
	public void invitation_comment1(String invicomment1) throws InterruptedException{
		homePage.invidetail_comment(invicomment1) ;
		homePage.byby();
		Thread.sleep(2000);
	}
	//添加孩子（数据驱动）13、14、15、16、17、18、19、20
	@DataProvider(name="test3")
	 public Object[][] createData3() throws IOException{
		 ExcelDataProvider provider = new ExcelDataProvider();
		 return provider.getTestDataByExcel("E:\\shixun.xlsx","addchild1");
	 }
	@Test(priority=6,dataProvider="test3")
	public void addchidrensuccess(String name,String year,String month,String day) throws InterruptedException{
		Thread.sleep(2000);
		homePage.add_childrensuccess(name,year,month,day) ;
		homePage.byby();
		Thread.sleep(2000);
	}
	
	@DataProvider(name="test4")
	 public Object[][] createData4() throws IOException{
		 ExcelDataProvider provider = new ExcelDataProvider();
		 return provider.getTestDataByExcel("E:\\shixun.xlsx","addchild2");
	 }
	@Test(priority=7,dataProvider="test4")
	public void addchidrenfail(String name,String year,String month,String day) throws InterruptedException{
		Thread.sleep(2000);
		homePage.add_childrenfail(name,year,month,day) ;
		homePage.byby();
		Thread.sleep(2000);
	}
	//修改昵称21
	@Test(priority=8)
	public void edit_childnickname() throws InterruptedException{
		homePage.edit_nickname("dada") ;
		homePage.byby();
		Thread.sleep(2000);
	}
	//修改生日22
	@Test(priority=9)
	public void edit_childbirthday() throws InterruptedException{
		homePage.edit_birthday("2009","8","22");
		homePage.byby();
		Thread.sleep(2000);
	}
	//删除孩子-确定删除23
	@Test(priority=10)
	public void deletechildren_ok() throws InterruptedException{
		homePage.delete_childrenok();
		homePage.byby();
		Thread.sleep(2000);
	}
	//删除孩子-取消删除24
	@Test(priority=11)
	public void deletechildren_no() throws InterruptedException{
		homePage.delete_childrenno();
		homePage.byby();
		Thread.sleep(2000);
	}
}
