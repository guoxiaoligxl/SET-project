package ch1218;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.edu.utils.Common;
/**
 * @author 李璇
 */
public class getFee {
	String fee_url ="/getfee";
	Checker check = null;
	//获取id=1的地址的运费
	@Test
	public void getfee1() throws Exception{
		CookieStore cookie = Common.getCookie("20000000000", "netease123");
		Map<String,Object> fee_para =new HashMap<String,Object>(); 
		fee_para.put("id","1");
		fee_para.put("address","河北省_石家庄市_裕华区");
		String fee_result = HttpDriver.doGet(fee_url,HttpDriver.mapToString(fee_para),cookie);
		System.out.println(fee_result);
		check =new Checker(fee_result);
	}
	//获取id=2的地址的运费
	@Test
	public void getfee2() throws Exception{
		CookieStore cookie = Common.getCookie("20000000000", "netease123");
		Map<String,Object> fee_para =new HashMap<String,Object>(); 
		fee_para.put("id","2");
		fee_para.put("address","重庆市_沙坪坝区");
		String fee_result = HttpDriver.doGet(fee_url,HttpDriver.mapToString(fee_para),cookie);
		System.out.println(fee_result);
		check =new Checker(fee_result);
	}
}
   
