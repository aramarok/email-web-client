package net.emailwebclient.dao.tables;

public enum EmailAccountTable {

	EMAIL_ACCOUNT_ID, PROTOCOL, HOST, PORT, USER_NAME, PASSWORD, EMAIL_ADDRESS, USER_ID, USE_EMAIL_ACCOUNT;

	public String getName() {
		return toString();
	}
}
