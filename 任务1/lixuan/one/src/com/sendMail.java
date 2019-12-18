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
 * ���
 */
public class sendMail {
	@Test
	public void toMail(String result2) throws IOException {
//		1������Properties����
		Properties prop=new Properties();
		String frommail = ReadProperties.getPropertyValue("frommail");
		String auth_code = ReadProperties.getPropertyValue("auth_code");
		String tomail = ReadProperties.getPropertyValue("tomail");
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.host", "smtp.163.com");
		prop.put("mail.smtp.auth", true);
//		2��Session�������÷����䡢��Ȩ��
		Session session=Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(frommail,auth_code);
			}
			
		});
//		3��Message�������ã������ˣ��ռ��ˣ����⣬����
		
		Message message=new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(frommail));
//			��ʾ�����԰��ռ��˵�ַ������properties�ļ���
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(tomail));
			message.setSubject("���Ա���");
			message.setText(result2);
////����
//			// ������Ϣ����
//			BodyPart messageBodyPart = new MimeBodyPart();
//
//			// ��Ϣ
//			messageBodyPart.setText("��һ���ʼ�");
//
//			// ����������Ϣ
//			Multipart multipart = new MimeMultipart();
//
//			// �����ı���Ϣ����
//			multipart.addBodyPart(messageBodyPart);
//
//			// ��������
//			messageBodyPart = new MimeBodyPart();
//
//
//			DataSource source = new FileDataSource("E:\\result.html");
//			messageBodyPart.setDataHandler(new DataHandler(source));
//
//			// messageBodyPart.setFileName(filename);
//			// �������������ģ������ļ�·������������
//			messageBodyPart.setFileName(MimeUtility.encodeText("E:\\result.html"));
//			multipart.addBodyPart(messageBodyPart);
//
//			// ����������Ϣ
//			message.setContent(multipart);
//			
//			
//			
//			4��ʹ��Transport����
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
