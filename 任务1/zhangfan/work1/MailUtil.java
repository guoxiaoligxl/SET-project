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
 * �ŷ�
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
		// 3��Message�������ã������ˣ��ռ��ˣ����⣬����

		Message message = new MimeMessage(session);
		// �������������ָ������Ķ���
		// MimeMessage message=new MimeMessage(session);
		message.setFrom(new InternetAddress(ReadProperties.getPropertyValue("from")));
		// ��ʾ�����԰��ռ��˵�ַ������properties�ļ���
	message.addRecipient(Message.RecipientType.TO, new InternetAddress(ReadProperties.getPropertyValue("send_to")));
		message.setSubject("����	����");
		message.setText(zhang);

		// ������Ϣ����
		//BodyPart messageBodyPart = new MimeBodyPart();

		// ��Ϣ
		//messageBodyPart.setText("���Ա����ڸ�����");

		// ����������Ϣ
		//Multipart multipart = new MimeMultipart();

		// �����ı���Ϣ����
		//multipart.addBodyPart(messageBodyPart);

		// ��������
		//messageBodyPart = new MimeBodyPart();
		// ����Ҫ���͸������ļ�·��		
		//Date date = new Date();
		//DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		//String newdate = df2.format(date);

		//DataSource source = new FileDataSource("D:\\eclipse\\rest\\src\\training\\"+newdate+".html");
		//messageBodyPart.setDataHandler(new DataHandler(source));

		// messageBodyPart.setFileName(filename);
		// �������������ģ������ļ�·������������
		//messageBodyPart.setFileName(MimeUtility.encodeText("D:\\eclipse\\rest\\src\\training\\"+newdate+".html"));
		//multipart.addBodyPart(messageBodyPart);

		// ����������Ϣ
		//message.setContent(multipart);
		// 4��ʹ��Transport����
		Transport.send(message);
	}
}