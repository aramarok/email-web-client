package net.emailwebclient.dao.tables;

public enum EmailTable {

	EMAIL_ID, EMAIL_ACCOUNT_ID, FROM_, REPLY_TO, TO_, CC, BCC, DATE, SUBJECT, CONTENT, TYPE;

	public String getName() {
		return toString();
	}
}