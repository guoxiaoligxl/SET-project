package com.webtest.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import java.util.Date;
import com.webtest.utils.ReadProperties;
/*
 * 张帆
 */
public class MailUtil {

	public static void sendEmail(String zhang) throws Exception {
		String from = ReadProperties.getPropertyValue("from");
		String password = ReadProperties.getPropertyValue("password");
		Properties props = new Properties();
		props.put("mail.smtp.host", ReadProperties.getPropertyValue("server"));
		props.put("mail.smtp.port", ReadProperties.getPropertyValue("port"));
		props.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, password);
			}

		});
		// 3、Message对象设置，发件人，收件人，主题，正文

		Message message = new MimeMessage(session);
		// 或者子类的引用指向子类的对象
		// MimeMessage message=new MimeMessage(session);
		message.setFrom(new InternetAddress(ReadProperties.getPropertyValue("from")));
		// 提示：可以把收件人地址配置在properties文件中
	message.addRecipient(Message.RecipientType.TO, new InternetAddress(ReadProperties.getPropertyValue("send_to")));
		message.setSubject("测试	报告");
		message.setText(zhang);

		// 创建消息部分
		//BodyPart messageBodyPart = new MimeBodyPart();

		// 消息
		//messageBodyPart.setText("测试报告在附件中");

		// 创建多重消息
		//Multipart multipart = new MimeMultipart();

		// 设置文本消息部分
		//multipart.addBodyPart(messageBodyPart);

		// 附件部分
		//messageBodyPart = new MimeBodyPart();
		// 设置要发送附件的文件路径		
		//Date date = new Date();
		//DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		//String newdate = df2.format(date);

		//DataSource source = new FileDataSource("D:\\eclipse\\rest\\src\\training\\"+newdate+".html");
		//messageBodyPart.setDataHandler(new DataHandler(source));

		// messageBodyPart.setFileName(filename);
		// 处理附件名称中文（附带文件路径）乱码问题
		//messageBodyPart.setFileName(MimeUtility.encodeText("D:\\eclipse\\rest\\src\\training\\"+newdate+".html"));
		//multipart.addBodyPart(messageBodyPart);

		// 发送完整消息
		//message.setContent(multipart);
		// 4、使用Transport发送
		Transport.send(message);
	}
}