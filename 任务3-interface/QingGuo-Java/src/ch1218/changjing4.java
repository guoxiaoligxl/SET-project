package ch1218;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.CookieStore;

import com.edu.core.HttpDriver;
import com.edu.utils.Common;
import org.testng.annotations.Test;
import net.sf.json.JSONObject;
/**
 * @author 李璇
 */
public class changjing4 {
	String address_list_url="/getAddress";
	String fee_url ="/getfee";
	String submit_url="/qingguo/submit";
	@Test
	public void testChangjing() throws Exception{
		//场景4：完整下单流程(已登录、有收货地址) 查询收货地址，计算运费，提交订单
		//1.登录（可省略）
		CookieStore cookie = Common.getCookie("20000000000", "netease123");
		//2.获取地址
		Map<String,Object> address =new HashMap<String,Object>(); 
		address.put("id","1");
//		address.put("province", "河北省");
		String address_result = HttpDriver.doGet(address_list_url,HttpDriver.mapToString(address),cookie);
		System.out.println("查询的地址为："+address_result);
		//3.获取运费
		Map<String,Object> fee_para =new HashMap<String,Object>(); 
		fee_para.put("id","1");
		fee_para.put("address","河北省_石家庄市_裕华区");
		String fee_result = HttpDriver.doGet(fee_url,HttpDriver.mapToString(fee_para),cookie);
		System.out.println("所获取地址的运费为："+fee_result);
		//4.Submit
	   JSONObject submit_para = new JSONObject();
		submit_para.element("skuIds", "1");
		submit_para.element("receiverName","lisi");
		submit_para.element("cellPhone","20000000004");
		submit_para.element("addressDetail","nanjingdaxue");
		submit_para.element("province","jiangsusheng");
		submit_para.element("city","nanjingshi");
		submit_para.element("area","gulouqu");
		submit_para.element("transportFee","7.0");
	    String submit = HttpDriver.doPost(submit_url, submit_para,cookie);
	    System.out.println("提交订单情况为："+submit);
	}
}

