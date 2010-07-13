package net.emailwebclient.dao.tables;

public enum UsersTable {

	USER_ID, USER_NAME, PASSWORD, FIRST_NAME, LAST_NAME, CITY, AGE, SEX;

	public String getName() {
		return toString();
	}

}