package ch1218;

import java.io.IOException;

import org.apache.http.client.CookieStore;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.edu.utils.Common;
import net.sf.json.JSONObject;
/**
 * @author 周倩倩
 */
public class addAddress1 {
	String base_url5= "/fgadmin/address/new"; 
	Checker check = null;
	public void testGetAddress(String province,String area,String id) throws IOException, Exception{
		CookieStore cookie = Common.getCookie("20000000000", "netease123");
		JSONObject user=new JSONObject();		
		user.element("province", province);
//		user.element("city", city);
		user.element("area", area);
		user.element("id", id);
		String result = HttpDriver.doPost(base_url5,user,cookie);
		System.out.println(result);
		System.out.println(user);
		check = new Checker(result);
	}
	@Test
	public void test1() throws IOException, Exception{
		testGetAddress("河北省", "石家庄市_裕华区","1");
		check.verifyTextPresent("msg");
	}
	
}
