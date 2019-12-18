package ch1218;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
/**
 * @author ÷‹ŸªŸª
 */
public class changjing1 {
	String skulist_url="/common/skuList";
	Checker check = null;
	public void getSkulistByPara(Map para) throws Exception {
		String result = HttpDriver.doGet(skulist_url,HttpDriver.mapToString(para));
		check = new Checker(result);
	}
//	≥°æ∞“ª
	@Test
	public void test3() throws Exception{
		Map<String, Object> skuid = new HashMap<String, Object>();
		skuid.put("id", "0");
		getSkulistByPara(skuid);
		
		Map<String, Object> skuid1 = new HashMap<String, Object>();
		skuid1.put("id", "1");
		getSkulistByPara(skuid1);
		
		Map<String, Object> skuid2 = new HashMap<String, Object>();
		skuid2.put("id", "2");
		getSkulistByPara(skuid2);
		
		Map<String, Object> skuid3 = new HashMap<String, Object>();
		skuid3.put("id", "3");
		getSkulistByPara(skuid3);
	}


}
