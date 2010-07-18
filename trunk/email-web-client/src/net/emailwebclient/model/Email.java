package net.emailwebclient.model;

import java.util.Date;

import net.emailwebclient.dao.tables.EmailTypes;
import net.emailwebclient.view.managedbeans.home.EMailContent;

public class Email {

	private long emailId;
	private long emailAccountId;
	private String from;
	private String replyTo;
	private String to;
	private String cc;
	private String bcc;
	private Date date;
	private String subject;
	private String content;
	private EmailTypes type;

	private boolean selected; // For UI selection

	public void copyFromEMailContentObject(EMailContent emailContent) {
		from = emailContent.getSenderEmailAddress();
		// replyTo =
		if (emailContent.getDestinationToEmailAddresses() != null) {
			for (String t : emailContent.getDestinationToEmailAddresses()) {
				to += t + ", ";
			}
		}
		if (emailContent.getDestinationCCEmailAddresses() != null) {
			for (String c : emailContent.getDestinationCCEmailAddresses()) {
				cc += c + ", ";
			}
		}
		if (emailContent.getDestinationBCCEmailAddresses() != null) {
			for (String b : emailContent.getDestinationBCCEmailAddresses()) {
				bcc += b + ", ";
			}
		}
		subject = emailContent.getSubject();
		content = emailContent.getContent();
	}

	// ////////////////////////
	// Getters and setters
	// ////////////////////////

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public long getEmailId() {
		return emailId;
	}

	public void setEmailId(long emailId) {
		this.emailId = emailId;
	}

	public long getEmailAccountId() {
		return emailAccountId;
	}

	public void setEmailAccountId(long emailAccountId) {
		this.emailAccountId = emailAccountId;
	}

	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public EmailTypes getType() {
		return type;
	}

	public void setType(EmailTypes type) {
		this.type = type;
	}

}