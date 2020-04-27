package edu.testcase;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.dataprovider.ExcelDataProvider;

import edu.base.BaseTest;
import edu.pages.CommunityPage;
import edu.pages.LoginPage;

public class CommunityPageTest extends BaseTest{
	@DataProvider(name="addpost")
	public Object[][] createData1() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\data.xlsx", "addpostdata");
	}
	@DataProvider(name="commentsuccess")
	public Object[][] createData2() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\data.xlsx", "commentsuccessdata");
	}
	@DataProvider(name="commentfail")
	public Object[][] createData3() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\data.xlsx", "commentfaildata");
	}
	@DataProvider(name="replytocomment")
	public Object[][] createData4() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\data.xlsx", "replytocommentdata");
	}
	@DataProvider(name="textcontent")
	public Object[][] createData5() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\data.xlsx", "textcontentdata");
	}
	
	
	
	
	
	
	
	
	
	
	@BeforeMethod
	public void testLogin(){
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginSuccess("18812092925","1234567890zf");
	}
	@AfterMethod
	public void testQuit(){
		LoginPage loginpage=new LoginPage(driver);
		loginpage.quitAfterLoginSuccess();
	}
	@Test(dataProvider="addpost")
	public void testAddPost(String postcontent){
		CommunityPage communitypage=new CommunityPage(driver);
		communitypage.addPost(postcontent);
	}
	@Test
	public void testDianzan(){
		CommunityPage communitypage=new CommunityPage(driver);
		communitypage.dianzan();
		
	}
	@Test(dataProvider="commentsuccess")
	public void testCommentSuccess(String commentcontent){
		CommunityPage communitypage=new CommunityPage(driver);
		communitypage.commentSuccess(commentcontent);
		
	}
	@Test(dataProvider="replytocomment")
	public void testReplyToComment(String content){
		CommunityPage communitypage=new CommunityPage(driver);
		communitypage.replyToComment(content);
	}
	@Test
	public void testaddPostWithOnePicture(){
		CommunityPage communitypage=new CommunityPage(driver);
		communitypage.addPostWithOnePicture();
	}
	@Test
	public void testaddPostWithSixPictures() throws InterruptedException{
		CommunityPage communitypage=new CommunityPage(driver);
		communitypage.addPostWithSixPictures();
	}
	@Test(dataProvider="textcontent")
	public void testaddPostWithOnePictureAndText(String text){
		CommunityPage communitypage=new CommunityPage(driver);
		communitypage.addPostWithOnePictureAndText(text);
	}
	@Test(dataProvider="textcontent")
	public void testaddPostWithSixPicturesAndText(String text) throws InterruptedException{
		CommunityPage communitypage=new CommunityPage(driver);
		communitypage.addPostWithSixPicturesAndText(text);
	}
}
