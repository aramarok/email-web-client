package net.emailwebclient.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EMailSender {

	public static boolean send(EMail email) {

		Properties props = new Properties();
		props.put(Constants.SMTP_USER, email.getSenderEmailAddress());
		props.put(Constants.SMTP_HOST, email.getSenderHost());
		props.put(Constants.SMTP_PORT, email.getSenderPort());
		props.put(Constants.SMTP_START_TLS_ENABLE, "true");
		props.put(Constants.SMTP_AUTH, "true");
		props.put(Constants.SMTP_DEBUG, "true");
		props.put(Constants.SMTP_SOCKET_FACTORY_PORT, email.getSenderPort());
		props.put(Constants.SMTP_SOCKET_FACTORY_CLASS, Constants.SSL_SOCKET_FACTORY);
		props.put(Constants.SMTP_SOCKET_FACTORY_FALLBACK, "false");

		// SecurityManager security = System.getSecurityManager();
		try {
			Authenticator auth = new SMTPAuthenticator(email);
			Session session = Session.getInstance(props, auth);
			MimeMessage msg = new MimeMessage(session);
			msg.setSubject(email.getSubject());
			msg.setContent(email.getContent(), "text/html");
			msg.setFrom(new InternetAddress(email.getSenderEmailAddress()));
			if (email.getDestinationToEmailAddresses() != null) {
				for (String to : email.getDestinationToEmailAddresses()) {
					if (!to.trim().isEmpty()) {
						msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
					}
				}
			}
			if (email.getDestinationCCEmailAddresses() != null) {
				for (String cc : email.getDestinationCCEmailAddresses()) {
					if (!cc.trim().isEmpty()) {
						msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
					}
				}
			}
			if (email.getDestinationBCCEmailAddresses() != null) {

				for (String bcc : email.getDestinationBCCEmailAddresses()) {
					if (!bcc.trim().isEmpty()) {
						msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));
					}
				}
			}
			Transport.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private static class SMTPAuthenticator extends javax.mail.Authenticator {

		private EMail email;

		SMTPAuthenticator(EMail email) {
			super();
			this.email = email;
		}

		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(email.getSenderEmailAddress(), email.getSenderEmailPassword());
		}
	}
}