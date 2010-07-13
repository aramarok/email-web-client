package net.emailwebclient.dao.tables;

public enum EmailTable {

	EMAIL_ID, EMAIL_ACCOUNT_ID, FROM_, DATE, SUBJECT;

	public String getName() {
		return toString();
	}
}