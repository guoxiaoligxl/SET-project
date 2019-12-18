package ch1218;
import java.io.IOException;
/**
 * @author ÕÅ·«
 */

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;
import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.edu.utils.Common;

import net.sf.json.JSONObject;
public class Submit1 {
	String submit_url="/qingguo/submit";
	Checker check=null;
	@Test
	public void testSubmitSuccess() throws IOException, Exception{
		CookieStore cookie = Common.getCookie("20000000000", "netease123");
		JSONObject submit_para=new JSONObject();
		submit_para.element("skuIds", "1");
		submit_para.element("receiverName","lisi");
		submit_para.element("cellPhone","20000000004");
		submit_para.element("addressDetail","nanjingdaxue");
		submit_para.element("province","jiangsusheng");
		submit_para.element("city","nanjingshi");
		submit_para.element("area","gulouqu");
		submit_para.element("transportFee","7.0");
		String result=HttpDriver.doPost(submit_url,submit_para,cookie);
		System.out.println(result);
		check=new Checker(result);
		
	}
	
	
}
