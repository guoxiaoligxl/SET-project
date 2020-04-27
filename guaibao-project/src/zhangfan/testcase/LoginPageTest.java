package edu.testcase;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.dataprovider.ExcelDataProvider;

import edu.base.BaseTest;
import edu.pages.LoginPage;

public class LoginPageTest extends BaseTest{
	@DataProvider(name="loginsuccess")
	public Object[][] createData1() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\data.xlsx", "loginsuccessdata");
	}
	
	@Test(dataProvider="loginsuccess")
	public void testLoginSuccess(String phonenumber,String password){
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginSuccess(phonenumber,password);
		loginpage.quitAfterLoginSuccess();
	}
	
	//单个测试
	@Test
	public void testLoginFail() throws InterruptedException{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginFail("111","111");
	}
	
	
}
