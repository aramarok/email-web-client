package net.emailwebclient.dao.tables;

public enum ContactsTable {

	CONTACT_ID, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, INFO, USER_ID;

	public String getName() {
		return toString();
	}
}