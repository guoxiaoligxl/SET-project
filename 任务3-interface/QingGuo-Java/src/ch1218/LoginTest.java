package ch1218;

import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;

import net.sf.json.JSONObject;
/**
 * @author 李璇
 */
public class LoginTest {
//	http:/\/study-perf.qa.netease.com/common/fgadmin/login
	//String login_url="/common/fgadmin/login";
	String login_url="/login";
	Checker check = null;
	public void login(Object phoneArea,Object phoneNumber,Object password){
		JSONObject user = new JSONObject();
		user.element("phoneArea", phoneArea);
		user.element("phoneNumber", phoneNumber);
		user.element("password", password);
		String result = HttpDriver.doPost(login_url, user);
		check =new Checker(result);
		System.out.println(result);
	}
	@Test
	public void testLoginSuccess() throws Exception{
		login("86","20000000000","netease123");
		check.verifyTextPresent("msg");
//		check.verifyXpath("code","200");
	}
	
	@Test
	public void testLoginFail() throws Exception{
		login("86","20000000001","netease123");
		check.verifyTextPresent("msg");
//		check.verifyXpath("code","400");
	}
	
//	@Test
//	public void testLoginForWrongPhone() throws Exception{
//		login("86","200000000000","netease123");
//		check.verifyTextPresent("message");
//		//check.verifyXpath("message","WrongPhone");
//		check.verifyXpath("code","400");
//	}
//	
//	@Test
//	public void testLoginForWrongNumber() throws Exception{
//		login("86","20000000000","netease1233");
//		check.verifyXpath("message","用户名或者密码错误");
//	}

}
