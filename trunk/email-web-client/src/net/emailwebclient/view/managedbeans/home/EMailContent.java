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
	private long port;

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

	public void setPort(long port) {
		this.port = port;
	}

	public String getContent() {
		return content;
	}

	public String[] getDestinationBCCEmailAddresses() {
		return bcc;
	}

	public String[] getDestinationCCEmailAddresses() {
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

	public long getSenderPort() {
		return port;
	}

	public String getSubject() {
		return subject;
	}

}