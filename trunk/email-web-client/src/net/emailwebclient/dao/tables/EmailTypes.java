package net.emailwebclient.dao.tables;

public enum EmailTypes {

	INBOX, SENT, DRAFT, TRASH;

	public static EmailTypes getEmailType(int emailType) {
		switch (emailType) {
		case 0:
			return INBOX;
		case 1:
			return SENT;
		case 2:
			return DRAFT;
		case 3:
			return TRASH;
		default:
			return INBOX;
		}
	}

	public static int getEmailType(EmailTypes e) {
		switch (e) {
		case INBOX:
			return 0;
		case SENT:
			return 1;
		case DRAFT:
			return 2;
		case TRASH:
			return 3;
		default:
			return 0;
		}
	}

}