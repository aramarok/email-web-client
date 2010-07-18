package net.emailwebclient.view.managedbeans.home;

import net.emailwebclient.email.EMail;

public class EMailContent implements EMail {

	private String from;
	private String[] to;
	private String[] cc;
	private String[] bcc;
	private String subject;
	private String content;

	private String password;
	private String host;
	private int port;

	public EMailContent(String[] to, String[] cc, String[] bcc, String subject, String content) {
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
		this.subject = subject;
		this.content = content;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getContent() {
		return content;
	}

	public String[] getDestinationBCCEmailAddresses() {
		System.out.println("bcc " + bcc);
		return bcc;
	}

	public String[] getDestinationCCEmailAddresses() {
		System.out.println("cc -" + cc[0]+"-");
		return cc;
	}

	public String[] getDestinationToEmailAddresses() {
		return to;
	}

	public String getSenderEmailAddress() {
		return from;
	}

	public String getSenderEmailPassword() {
		return password;
	}

	public String getSenderHost() {
		return host;
	}

	public int getSenderPort() {
		return port;
	}

	public String getSubject() {
		return subject;
	}

}