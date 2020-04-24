package guoxiaoli.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import guoxiaoli.utils.ExcelDataProvider;

import guoxiaoli.base.BaseTest;
import guoxiaoli.pages.ForgetPage;

public class ForgetPageTest extends BaseTest{

	@Test(priority=1)
	public void feditsuccess(){
		ForgetPage forgetPage=new ForgetPage(driver);
		forgetPage.feditSuccess("1573281241", "1302", "123456gxl", "123456gxl");
		Assert.assertEquals(this.driver.currentActivity(),".Login.RegisterActivity");
	}
	
	
	@DataProvider(name="f_fail")
	public Object[][] createData2() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\kejian\\softwaretest\\shixun2\\guoxiaoli.xlsx","forgetpage");
	}
	@Test(priority=2,dataProvider="f_fail")
	public void feditfail(String user_name,String yan,String psd,String repsd){
		ForgetPage forgetPage=new ForgetPage(driver);
		forgetPage.feditFail(user_name, yan , psd, repsd);
		Assert.assertEquals(this.driver.currentActivity(),".Login.RegisterActivity");
	}
	
//	@Test
//	public void feditfail_phone(){//手机号码错误
//		ForgetPage forgetPage=new ForgetPage(driver);
//		forgetPage.feditFail("1573281242", "1302", "123456gxl", "123456gxl");
//		Assert.assertEquals(this.driver.currentActivity(),".Login.RegisterActivity");
//	}
//	
//	@Test
//	public void feditfail_psdlen(){//密码不足8位
//		ForgetPage forgetPage=new ForgetPage(driver);
//		forgetPage.feditFail("15732812241", "1302", "123456", "123456");
//		Assert.assertEquals(this.driver.currentActivity(),".Login.RegisterActivity");
//	}
//	
//	@Test
//	public void feditfail_psd(){//两次密码不一致
//		ForgetPage forgetPage=new ForgetPage(driver);
//		forgetPage.feditFail("15732812241", "1302", "123456gxl", "123456gxk");
//		Assert.assertEquals(this.driver.currentActivity(),".Login.RegisterActivity");
//	}
	
	
	
	
}
