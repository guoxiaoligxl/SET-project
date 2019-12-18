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
public class changjing3 {
	String address_list_url="/getAddress";//��ȡ��ַ
	String fee_url ="/getfee";//��ȡ�˷�
	String submit_url="/qingguo/submit";//�ύ����
	String base_url5= "/fgadmin/address/new"; //��ӵ�ַ
	@Test
	public void testChangjing() throws Exception{
		//����3�������µ�����(�ѵ�¼�����ջ���ַ)��ѯ��ַ����ӵ�ַ�������˷ѣ��ύ����
		//1.��¼����ʡ�ԣ�
		CookieStore cookie = Common.getCookie("20000000000", "netease123");
		//2.��ѯ��ַ
		Map<String,Object> address =new HashMap<String,Object>(); 
		address.put("id","3");
		String address_result = HttpDriver.doGet(address_list_url,HttpDriver.mapToString(address),cookie);
		System.out.println("��ѯ�ĵ�ַΪ��"+address_result);
		//3.��ӵ�ַ
		JSONObject user=new JSONObject();		
		user.element("province", "�ӱ�ʡ");
//		user.element("city", city);
		user.element("area", "ʯ��ׯ��_ԣ����");
		user.element("id", "1");
		String result = HttpDriver.doPost(base_url5,user,cookie);
		System.out.println("��ӵĵ�ַΪ��"+user);
		//4.��ȡ�˷�
		Map<String,Object> fee_para =new HashMap<String,Object>(); 
		fee_para.put("id","1");
		fee_para.put("address","�ӱ�ʡ_ʯ��ׯ��_ԣ����");
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
