package ch1218;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.edu.utils.Common;
/**
 * @author ���
 */
public class getFee {
	String fee_url ="/getfee";
	Checker check = null;
	//��ȡid=1�ĵ�ַ���˷�
	@Test
	public void getfee1() throws Exception{
		CookieStore cookie = Common.getCookie("20000000000", "netease123");
		Map<String,Object> fee_para =new HashMap<String,Object>(); 
		fee_para.put("id","1");
		fee_para.put("address","�ӱ�ʡ_ʯ��ׯ��_ԣ����");
		String fee_result = HttpDriver.doGet(fee_url,HttpDriver.mapToString(fee_para),cookie);
		System.out.println(fee_result);
		check =new Checker(fee_result);
	}
	//��ȡid=2�ĵ�ַ���˷�
	@Test
	public void getfee2() throws Exception{
		CookieStore cookie = Common.getCookie("20000000000", "netease123");
		Map<String,Object> fee_para =new HashMap<String,Object>(); 
		fee_para.put("id","2");
		fee_para.put("address","������_ɳƺ����");
		String fee_result = HttpDriver.doGet(fee_url,HttpDriver.mapToString(fee_para),cookie);
		System.out.println(fee_result);
		check =new Checker(fee_result);
	}
}
   
