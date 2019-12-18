package training;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
/*
 * 张帆
 */
public class GenerateReport {
	public static String createReport(Map<String,Object> map) throws IOException{
		Writer out=null;
		Template template=null;
		String resultHtml = null;
		Configuration conf=new Configuration();
		conf.setDefaultEncoding("utf-8");
		conf.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
		//加载模板
		conf.setDirectoryForTemplateLoading(new File("D:\\eclipse\\rest\\src\\training"));
		//创建模板
		template=conf.getTemplate("freemarker.ftl");
		
		//向模板内写入数据
		Map report=new HashMap<>();
		report.put("date", map.get("date"));
		report.put("passNumber", map.get("passNumber"));
		report.put("failedNumber", map.get("failedNumber"));
		report.put("skippedNumber", map.get("skippedNumber"));
		report.put("testName", map.get("testName"));
		report.put("count", map.get("count"));
		
		
		
		Date date=new Date();
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		String newdate=df.format(date);
		File files=new File("D:\\eclipse\\rest\\src\\training\\"+newdate+".html");//生成的报告的路径和名称
		FileOutputStream fos=null;
		fos=new FileOutputStream(files);
		OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
		Writer swriter=new StringWriter();
//		swriter=new BufferedWriter(osw);
		
		try {
			//生成html文件
			template.process(report,osw);
			template.process(report,swriter);
			resultHtml = swriter.toString();
	        System.out.println(swriter.toString());
	        swriter.close();
	       
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultHtml;
	
	}
}
