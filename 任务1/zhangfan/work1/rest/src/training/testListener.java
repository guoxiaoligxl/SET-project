package training;
import java.io.IOException;
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

import com.webtest.utils.MailUtil;
/*
 * 张帆
 */
public class testListener extends TestListenerAdapter{
	
	@Override
	public void onFinish(ITestContext ITestResult) {
		String zhang=null;
		StringBuilder str=new StringBuilder();
		ITestNGMethod[] methods=this.getAllTestMethods();
		str.append("一共执行了"+methods.length+"条测试用例\n");
		List<ITestResult> success=this.getPassedTests();
		str.append("一共成功了"+success.size()+"条测试用例\n");
		List<ITestResult> skipped=this.getSkippedTests();
		str.append("一共跳过了"+skipped.size()+"条测试用例\n");
		List<ITestResult> failed=this.getFailedTests();
		str.append("一共失败了"+failed.size()+"条测试用例\n");
		for(ITestResult f:failed){
			str.append("失败的测试用例为："+f.getInstanceName()+"-"+f.getName()+"\n");
		}
		System.out.println(str.toString());
		
		
		//生成测试的日期，通过的个数，失败的个数
		Date date=new Date();
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String newdate=df.format(date);
		Map<String,Object> para=new HashMap<String,Object>();
		para.put("date", newdate);
		para.put("passNumber", success.size());
		para.put("failedNumber",failed.size());
		para.put("skippedNumber", skipped.size());
		para.put("testName","test1");
		para.put("count", methods.length);
		
		//生成报告
		GenerateReport report=new GenerateReport();
		try {
			zhang = report.createReport(para);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			MailUtil.sendEmail(zhang);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
