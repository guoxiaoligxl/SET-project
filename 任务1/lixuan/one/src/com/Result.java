package com;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import freemarker.template.Configuration;
import freemarker.template.Template;
/*
 * Àîè¯
 */
public class Result {
	@Test
	public void printResult(Map<String, Object> map) throws Exception{
		Configuration configuration = new Configuration(Configuration.getVersion());
		configuration.setDirectoryForTemplateLoading(new File("WEB_INF/"));
		configuration.setDefaultEncoding("utf-8");
		Template template = configuration.getTemplate("result.ftl");
		JavaMailListener listener =new JavaMailListener();
		
		Map get =new HashMap<>();
		//get.put("date", map.get("date"));
		get.put("fail", map.get("fail"));
		get.put("pass", map.get("pass"));
		get.put("skip", map.get("skip"));
		get.put("all", map.get("all"));
		Writer out = new FileWriter(new File("E:/result.html"));
		Writer sWriter=new StringWriter();
        template.process(get, sWriter);
        String result2 = sWriter.toString();
        System.out.println(sWriter.toString());
		template.process(get, out);
		out.close();
		sendMail sendMail = new sendMail();
		sendMail.toMail(result2);
	}
}
