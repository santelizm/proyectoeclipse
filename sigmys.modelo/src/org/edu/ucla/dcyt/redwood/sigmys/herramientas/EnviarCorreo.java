package org.edu.ucla.dcyt.redwood.sigmys.herramientas;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class EnviarCorreo {

	private final Properties properties = new Properties();

	private final String username = "sistemasigmys@gmail.com";
	private final String password = "equipo2si";

	private Session session;

	private void init() {
		MailSSLSocketFactory sf = null;
		try {
			sf = new MailSSLSocketFactory();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sf.setTrustAllHosts(true);
		properties.put("mail.smtp.ssl.socketFactory", sf);
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.mail.sender", "sistemasigmys@gmail.com");

		session = Session.getInstance(properties,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

	}

	public void sendEmail(String correoReceptor, String clave) {
		init();
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress((String) properties
					.get("mail.smtp.mail.sender")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					correoReceptor));
			message.setSubject("Olvido su contrase�a");
			message.setText("La Recuperaci�n de contrase�a se realiz� "
					+ "satisfactoriamente."
					+ "\n\n SIGMYS le informa que su contrase�a para acceder a "
					+ "nuestro sistema es: " + clave
					+ "\n\n\t\t Sistema de Informaci�n "
					+ "para la Gesti�n de Materiales y Suministros");

			Transport.send(message);
			
			System.out.println("Enviado");

		} catch (MessagingException me) {
			throw new RuntimeException(me);
		}
	}
}
