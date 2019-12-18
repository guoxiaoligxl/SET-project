package com;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
/*
 * Àîè¯
 */
public class JavaMailListener extends TestListenerAdapter{
	public Map<String, Object> writeResultToMail() throws Exception
	{
		ITestNGMethod all[]=this.getAllTestMethods();
		List fail=this.getFailedTests();
		List pass=this.getPassedTests();
		List skip=this.getSkippedTests();
		List fail1=new ArrayList();
		List pass1=new ArrayList();
		List skip1=new ArrayList();
		for(int j=0;j<fail.size();j++)
		{
			
			ITestResult tr=(ITestResult) fail.get(j);
			if(tr.getMethod().getDescription()!=null)
			{
				tr.setAttribute("name", tr.getMethod().getDescription());
			}
			else
			{
				tr.setAttribute("name", "");
			}
		
			fail1.add(tr);
		}
		for(int j=0;j<pass.size();j++)
		{
			ITestResult tr=(ITestResult) pass.get(j);
			if(tr.getMethod().getDescription()!=null)
			{
				tr.setAttribute("name", tr.getMethod().getDescription());
			}
			else
			{
				tr.setAttribute("name", "");
			}
		
			pass1.add(tr);
		}
		for(int j=0;j<skip.size();j++)
		{
			ITestResult tr=(ITestResult) skip.get(j);
			if(tr.getMethod().getDescription()!=null)
			{
				tr.setAttribute("name", tr.getMethod().getDescription());
			}
			else
			{
				tr.setAttribute("name", "");
			}
		
			skip1.add(tr);
		}

		Map context=new HashMap();
    	context.put("date", new Date());
        context.put("fail",fail.size());   
        context.put("pass",pass.size()); 
        context.put("skip",skip.size());
        context.put("all",all.length); 
        Result result =new Result();
        result.printResult(context);
        try {
        	//String content=mapToString(context);
			return context;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static String  mapToString(Map<String, Object> para) {
			
			StringBuilder  sBuilder =new StringBuilder();
			int size=para.size();
			for(Entry<String, Object> entry:para.entrySet()) {
				sBuilder.append(entry.getKey()+"="+entry.getValue()+"\n");
				
			}
			
		return  sBuilder.toString();
					
		}
	@Override
public void onFinish(ITestContext testContext) {

	super.onFinish(testContext);
	System.out.println(getAllTestMethods().length);
	Map content=null;
		try {
			content = this.writeResultToMail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	String emailContent=mapToString(content);
	System.out.println(emailContent);
	}
//	   public String getTime()
//	    {
//	    	java.util.Calendar c=java.util.Calendar.getInstance();    
//	        java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");    
//	       	return  f.format(c.getTime());    
//	    }

}
