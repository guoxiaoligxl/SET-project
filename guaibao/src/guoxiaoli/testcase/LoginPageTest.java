package guoxiaoli.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import guoxiaoli.utils.ExcelDataProvider;

import guoxiaoli.base.BaseTest;
import guoxiaoli.pages.LoginPage;

public class LoginPageTest extends BaseTest{

	@Test(priority=1)
	public void loginsuccess() throws InterruptedException{//用户名，密码都正确
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginSuccess("1573281241", "123456gxl");
		Assert.assertEquals(this.driver.currentActivity(),".Host.MainActivity");
	}
	
	@DataProvider(name="l_fail")
	public Object[][] createData1() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\kejian\\softwaretest\\shixun2\\guoxiaoli.xlsx","loginpage");
	}
	@Test(priority=2,dataProvider="l_fail")
	public void loginfail(String user_name,String psd) throws InterruptedException{
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginFail(user_name, psd);
		Assert.assertEquals(this.driver.currentActivity(),".Login.LoginActivity");
	}
	
//	@Test
//	public void loginfail_phoneerror() throws InterruptedException{//用户名错误
//		LoginPage loginPage=new LoginPage(driver);
//		loginPage.loginFail("15732812242", "123456gxl");
//		System.out.println();
//		Assert.assertEquals(this.driver.currentActivity(),".Login.LoginActivity");
//	}
//	
	@Test
	public void loginfail_psderror() throws InterruptedException{//密码错误
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginFail("1573281241", "123456gxll");
//		System.out.println(loginPage.loginFail("1573281241", "123456gxll"));
		Assert.assertEquals(this.driver.currentActivity(),".Login.LoginActivity");
	}
//	
//	@Test
//	public void loginfail_phonelen(){//手机号码格式错误
//		LoginPage loginPage=new LoginPage(driver);
//		loginPage.loginFail("157328122", "123456gxl");
//		Assert.assertEquals(this.driver.currentActivity(),".Login.LoginActivity");
//	}
//	
//	@Test
//	public void loginfail_psdlen1(){//密码为空
//		LoginPage loginPage=new LoginPage(driver);
//		loginPage.loginSuccess("1573281241", "");
//		Assert.assertEquals(this.driver.currentActivity(),".Login.LoginActivity");
//	}
//	
//	@Test
//	public void loginfail_psdlen2(){//密码长度不足8位
//		LoginPage loginPage=new LoginPage(driver);
//		loginPage.loginFail("1573281241", "123456gx");
//		Assert.assertEquals(this.driver.currentActivity(),".Login.LoginActivity");
//	}
//	
//	@Test
//	public void oginfail_psdlen3(){//密码超过12位
//		LoginPage loginPage=new LoginPage(driver);
//		loginPage.loginFail("1573281241", "123456gxl12345");
//		Assert.assertEquals(this.driver.currentActivity(),".Login.LoginActivity");
//	}
	
	
	
}
