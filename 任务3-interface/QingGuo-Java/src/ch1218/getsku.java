package ch1218;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.edu.utils.ReadPro;
/**
 * @author ��ٻٻ
 */
public class getsku {
	String skulist_url="/common/skuList";
	Checker check = null;
	public void getSkulistByPara(Map para) throws Exception {
		String result = HttpDriver.doGet(skulist_url,HttpDriver.mapToString(para));
		check = new Checker(result);
	}
	//��ȡȫ����Ʒ��Ϣ
	@Test
	public void test1() throws Exception{
		Map<String, Object> skuid = new HashMap<String, Object>();
		skuid.put("id", "0");
		getSkulistByPara(skuid);
	}
	//��ȡidΪ1����Ʒ��Ϣ
	@Test
	public void test2() throws Exception{
		Map<String, Object> skuid1 = new HashMap<String, Object>();
		skuid1.put("id", "1");
		getSkulistByPara(skuid1);
	}



}
