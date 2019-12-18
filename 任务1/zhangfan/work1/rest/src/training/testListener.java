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
 * �ŷ�
 */
public class testListener extends TestListenerAdapter{
	
	@Override
	public void onFinish(ITestContext ITestResult) {
		String zhang=null;
		StringBuilder str=new StringBuilder();
		ITestNGMethod[] methods=this.getAllTestMethods();
		str.append("һ��ִ����"+methods.length+"����������\n");
		List<ITestResult> success=this.getPassedTests();
		str.append("һ���ɹ���"+success.size()+"����������\n");
		List<ITestResult> skipped=this.getSkippedTests();
		str.append("һ��������"+skipped.size()+"����������\n");
		List<ITestResult> failed=this.getFailedTests();
		str.append("һ��ʧ����"+failed.size()+"����������\n");
		for(ITestResult f:failed){
			str.append("ʧ�ܵĲ�������Ϊ��"+f.getInstanceName()+"-"+f.getName()+"\n");
		}
		System.out.println(str.toString());
		
		
		//���ɲ��Ե����ڣ�ͨ���ĸ�����ʧ�ܵĸ���
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
		
		//���ɱ���
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
