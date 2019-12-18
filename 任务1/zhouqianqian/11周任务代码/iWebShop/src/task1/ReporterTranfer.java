package task1;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
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
 * ��ٻٻ
 */
public class ReporterTranfer {

	
	public static String createDayReportFiles(Map<String,Object> map) {
	     BufferedInputStream in = null;
	     Writer out = null;  
	     Template template = null;
	     String resultHtml = null;
	     try {

	         //����Configuration�����ã�
	         Configuration configuration = new Configuration();
	         configuration.setDefaultEncoding("utf-8");  
	         configuration.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
	         configuration.setDirectoryForTemplateLoading(new File("D://Java//freemarker//"));//��ȡģ��·��
	         
	         
	         try {  
	             //test.ftlΪҪװ�ص�ģ��  
	         	template = configuration.getTemplate("1121.ftl");  //װ�ص�ģ������
	         } catch (IOException e) {  
	             e.printStackTrace();  
	         }  
	         

	 		Map data =new HashMap<>();
	 		data.put("date", map.get("date"));
	 		data.put("passNumber", map.get("passNumber"));
	 		data.put("FailedNumber", map.get("FailedNumber"));
	 		data.put("case1", map.get("case1"));
	 		data.put("count1",map.get("count1"));
	 		data.put("success1", map.get("success1"));
	 		data.put("skipped1", map.get("skipped1"));
	 		data.put("failed1",map.get("failed1"));  
	 		

	 		
	         
	         
	         
	         Date date = new Date();
	 		 DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd"); 
	 		 String  newdate = df2.format(date);
	        
	         //����ĵ�·��������  
	         File outFile = new File("D:\\Java\\freemarker\\result"+newdate+".html");  
	        
	         FileOutputStream fos = null;  
	         try {  
	             fos = new FileOutputStream(outFile);  
	             OutputStreamWriter oWriter = new OutputStreamWriter(fos,"UTF-8");  
	             //����ط������ı��벻�ɻ�ȱ��ʹ��main������������ʱ��Ӧ�ÿ��ԣ����������web���󵼳�ʱ������word�ĵ��ͻ�򲻿������Ұ�XML�ļ�������Ҫ�Ǳ����ʽ����ȷ���޷�������  
	              out = new BufferedWriter(oWriter);   
	              
	         } catch (FileNotFoundException e1) {  
	             e1.printStackTrace();  
	         }  
	         
	         
	         //����HTML
	         Writer sWriter=new StringWriter();
	         template.process(data, out);
	         template.process(data, sWriter);
	         resultHtml = sWriter.toString();
	         System.out.println(sWriter.toString());
	         out.close();
	         
	     } catch (FileNotFoundException e) {
	         e.printStackTrace();
	     } catch (UnsupportedEncodingException e) {
	         e.printStackTrace();
	     } catch (IOException e) {
	         e.printStackTrace();
	     } catch (TemplateException e) {
	         e.printStackTrace();
	     } finally {
	         if(null != in) {
	             try {
	                 in.close();
	             } catch (IOException e) {
	                 e.printStackTrace();
	             }
	         }
	         if(null != out) {
	             try {
	                 out.close();
	             } catch (IOException e) {
	                 e.printStackTrace();
	             }
	         }
	     }
		return resultHtml;
	     
	     
	     
	 }
	
	
	
	
}
