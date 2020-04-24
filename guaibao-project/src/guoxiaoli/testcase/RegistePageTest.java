package guoxiaoli.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import guoxiaoli.base.BaseTest;
import guoxiaoli.pages.LoginPage;
import guoxiaoli.pages.RegistePage;
import guoxiaoli.utils.ExcelDataProvider;

public class RegistePageTest extends BaseTest{

	@Test(priority=1)
	public void regissuccess(){
		RegistePage registePage=new RegistePage(driver);
		registePage.regisSuccess("15233625101", "2348", "123456gxl", "123456gxl");
		Assert.assertEquals(this.driver.currentActivity(),".Login.RegisterActivity");
	}
	@DataProvider(name="r_fail")
	public Object[][] createData1() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\kejian\\softwaretest\\shixun2\\guoxiaoli.xlsx","registepage");
	}
	@Test(priority=2,dataProvider="r_fail")
	public void loginfail(String user_name,String yan,String psd,String repsd){
		RegistePage registePage=new RegistePage(driver);
		registePage.regisFail(user_name, yan, psd, repsd);
		Assert.assertEquals(this.driver.currentActivity(),".Login.LoginActivity");
	}
	
//	@Test
//	public void regisfail_phone1(){//已注册号码
//		RegistePage registePage=new RegistePage(driver);
//		registePage.regisFail("1573281241", "2348", "123456gxl", "123456gxl");
//		Assert.assertEquals(this.driver.currentActivity(),".Login.RegisterActivity");
//	}
//	
//	@Test
//	public void regisfail_phone2(){//手机号码格式错误
//		RegistePage registePage=new RegistePage(driver);
//		registePage.regisFail("157328124", "2348", "123456gxl", "123456gxl");
//		Assert.assertEquals(this.driver.currentActivity(),".Login.RegisterActivity");
//	}
//	
//	@Test
//	public void regisfail_psdlen1(){//密码不足8位
//		RegistePage registePage=new RegistePage(driver);
//		registePage.regisFail("15233625101", "2348", "123456gx", "123456gx");
//		Assert.assertEquals(this.driver.currentActivity(),".Login.RegisterActivity");
//	}
//	
//	@Test
//	public void regisfail_psdlen2(){//密码超过12位
//		RegistePage registePage=new RegistePage(driver);
//		registePage.regisFail("15233625101", "2348", "123456gx12345", "123456gx12345");
//		Assert.assertEquals(this.driver.currentActivity(),".Login.RegisterActivity");
//	}
	
	
	
}
