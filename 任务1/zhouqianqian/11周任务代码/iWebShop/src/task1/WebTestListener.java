package task1;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.webtest.core.MailUtil;


/**
 * author:zhouqian 监听器，
 */

public class WebTestListener extends TestListenerAdapter {
	

	@Override
	public void onFinish(ITestContext ITestResult) {
		StringBuilder str = new StringBuilder();
		ITestNGMethod[] methods = this.getAllTestMethods();
		str.append("一共执行了" + methods.length + "条测试用例\n");
		List<ITestResult> success = this.getPassedTests();
		str.append("一共成功了" + success.size() + "条测试用例\n");
		List<ITestResult> skipped = this.getSkippedTests();
		str.append("一共跳过了" + skipped.size() + "条测试用例\n");
		List<ITestResult> fail = this.getFailedTests();
		str.append("一共失败了" + fail.size() + "条测试用例\n");
		for (ITestResult f : fail) {
			str.append("失败的测试用例为：" + f.getInstanceName() + "-" + f.getName() + "\n");
		}
		System.out.println(str.toString());
		
		Date date = new Date();
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		String  newdate = df2.format(date);
	
		Map<String, Object> para = new HashMap<String, Object>();
		para.put("date", newdate);
		para.put("passNumber", success.size());
		para.put("FailedNumber", fail.size());
		para.put("case1", "test1");
		para.put("count1",methods.length );
		para.put("success1", success.size());
		para.put("skipped1", skipped.size());
		para.put("failed1",fail.size());  
		
		ReporterTranfer result =new ReporterTranfer();
        String resultHtml = result.createDayReportFiles(para);
        

    	try {
			MailUtil.sendEmail(resultHtml);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
