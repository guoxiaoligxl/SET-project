package ch1218;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Common;
import com.edu.utils.Checker;
import net.sf.json.JSONObject;
/**
 * @author ¹ùÏþÀö
 */
public class deleteaddress1 {
	String delete_address_url="/fgadmin/address/delete";
    Checker check = null;
	public void delete(String province,String area,String id) throws Exception{
		CookieStore cookie = Common.getCookie("20000000000","netease123");
		JSONObject delete_body = new JSONObject();
		delete_body.element("province", province);
//		user.element("city", city);
		delete_body.element("area", area);
		delete_body.element("id", id);
		String result = HttpDriver.doPost(delete_address_url,delete_body,cookie);
		check =new Checker(result);
		System.out.println(result);
	}
	@Test
	public void test1() throws Exception{
		delete("Õã½­", "´óÑ§","1");
		check.verifyTextPresent("msg");
	}

}


