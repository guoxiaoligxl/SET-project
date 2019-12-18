package com;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.testng.annotations.Test;

import com.webtest.utils.ReadProperties;
/*
 * 李璇
 */
public class sendMail {
	@Test
	public void toMail(String result2) throws IOException {
//		1、创建Properties对象
		Properties prop=new Properties();
		String frommail = ReadProperties.getPropertyValue("frommail");
		String auth_code = ReadProperties.getPropertyValue("auth_code");
		String tomail = ReadProperties.getPropertyValue("tomail");
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.host", "smtp.163.com");
		prop.put("mail.smtp.auth", true);
//		2、Session对象，设置发件箱、授权码
		Session session=Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(frommail,auth_code);
			}
			
		});
//		3、Message对象设置，发件人，收件人，主题，正文
		
		Message message=new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(frommail));
//			提示：可以把收件人地址配置在properties文件中
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(tomail));
			message.setSubject("测试报告");
			message.setText(result2);
////附件
//			// 创建消息部分
//			BodyPart messageBodyPart = new MimeBodyPart();
//
//			// 消息
//			messageBodyPart.setText("第一封邮件");
//
//			// 创建多重消息
//			Multipart multipart = new MimeMultipart();
//
//			// 设置文本消息部分
//			multipart.addBodyPart(messageBodyPart);
//
//			// 附件部分
//			messageBodyPart = new MimeBodyPart();
//
//
//			DataSource source = new FileDataSource("E:\\result.html");
//			messageBodyPart.setDataHandler(new DataHandler(source));
//
//			// messageBodyPart.setFileName(filename);
//			// 处理附件名称中文（附带文件路径）乱码问题
//			messageBodyPart.setFileName(MimeUtility.encodeText("E:\\result.html"));
//			multipart.addBodyPart(messageBodyPart);
//
//			// 发送完整消息
//			message.setContent(multipart);
//			
//			
//			
//			4、使用Transport发送
			Transport.send(message);
		
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
