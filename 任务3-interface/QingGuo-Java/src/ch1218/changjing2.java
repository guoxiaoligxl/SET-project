package ch1218;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Common;

import net.sf.json.JSONObject;
/**
 * @author ���
 */
public class changjing2 {
	String login_url="/login";
	String address_list_url="/getAddress";
	String fee_url ="/getfee";
	String submit_url="/qingguo/submit";
	@Test
	public void testChangjing() throws Exception{
		//����2�������µ�����(δ��¼�����ջ���ַ) ��¼�ɹ�����ѯ�ջ���ַ�������˷ѣ��ύ����
		//1.��¼
		JSONObject user = new JSONObject();
		String phoneNumber="20000000000";
		String password="netease123";
		user.element("phoneArea", "86");
		user.element("phoneNumber",phoneNumber);
		user.element("password", password);
		String result = HttpDriver.doPost(login_url, user);
		System.out.println("��¼���Ϊ��"+result);
		//2.��ȡ��ַ
		CookieStore cookie = Common.getCookie(phoneNumber, password);
		Map<String,Object> address =new HashMap<String,Object>(); 
		address.put("id","2");
//		address.put("province", "�ӱ�ʡ");
		String address_result = HttpDriver.doGet(address_list_url,HttpDriver.mapToString(address),cookie);
		System.out.println("��ѯ�ĵ�ַΪ��"+address_result);
		//3.��ȡ�˷�
		Map<String,Object> fee_para =new HashMap<String,Object>(); 
		fee_para.put("id","2");
		//fee_para.put("address","�ӱ�ʡ_ʯ��ׯ��_ԣ����");
		fee_para.put("address","������_ɳƺ����");
		String fee_result = HttpDriver.doGet(fee_url,HttpDriver.mapToString(fee_para),cookie);
		System.out.println("����ȡ��ַ���˷�Ϊ��"+fee_result);
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
	    System.out.println("�ύ�������Ϊ��"+submit);
	}

}
