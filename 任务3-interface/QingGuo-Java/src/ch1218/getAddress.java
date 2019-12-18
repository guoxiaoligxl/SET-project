package ch1218;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Common;
import com.edu.utils.Checker;

/**
 * @author �ŷ�
 */
public class getAddress {
	String address_list_url="/getAddress";
	Checker check = null;
	public void getaddress(Map para) throws Exception{
		CookieStore cookie = Common.getCookie("20000000000", "netease123");
		String address_result = HttpDriver.doGet(address_list_url,HttpDriver.mapToString(para),cookie);
		check = new Checker(address_result);
		System.out.println(address_result);
	}
	//��ȡ���е�ַ
		@Test
		public void test1() throws Exception{
		Map<String, Object> id = new HashMap<String, Object>();
		id.put("id", "0");
		getaddress(id);
		//check.verifyTextPresent("province");
	}
   //��ȡidΪ1�ĵ�ַ
	@Test
	public void test2() throws Exception{
		Map<String, Object> id = new HashMap<String, Object>();
		id.put("id", "1");
		getaddress(id);
		check.verifyTextPresent("province");
	}
	//��ȡʱ�޵�ַ
		@Test
		public void test3() throws Exception{
			Map<String, Object> id = new HashMap<String, Object>();
			id.put("id", "3");
			getaddress(id);
			//check.verifyTextPresent("province");
		}
}
