package guoxiaoli.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import guoxiaoli.base.BaseTest;
import guoxiaoli.pages.HomePage;
//com.example.lenovo.maandroid/.Mine.Set 进入设置
public class HomePageTest extends BaseTest{
//	com.example.lenovo.maandroid/.Mine.MineSetgongneng
	@Test
	public void intro(){
		HomePage homePage=new HomePage(driver);
		homePage.introduce();
		Assert.assertEquals(this.driver.currentActivity(),".Mine.MineSetgongneng");
	}
	
//	com.example.lenovo.maandroid/.Mine.MineSetxieyi
	@Test
	public void service(){
		HomePage homePage=new HomePage(driver);
		homePage.serve();
		Assert.assertEquals(this.driver.currentActivity(),".Mine.MineSetxieyi");
	}
	
//	com.example.lenovo.maandroid/.Mine.Set
	@Test
	public void version(){
		HomePage homePage=new HomePage(driver);
		homePage.version();
		Assert.assertEquals(this.driver.currentActivity(),".Mine.Set");
	}
	
//	com.example.lenovo.maandroid/.Mine.MineSethelp
	public void help(){
		HomePage homePage=new HomePage(driver);
		homePage.help();
		Assert.assertEquals(this.driver.currentActivity(),".Mine.MineSethelp");
	}
	
//	com.example.lenovo.maandroid/.Login.LoginActivity
	public void goout(){
		HomePage homePage=new HomePage(driver);
		homePage.loginout();
		Assert.assertEquals(this.driver.currentActivity(),".Login.LoginActivity");
	}
	
	
	
}
