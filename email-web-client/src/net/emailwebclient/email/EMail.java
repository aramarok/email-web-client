package net.emailwebclient.email;

public interface EMail {

	String getSenderEmailAddress();

	String getSenderEmailPassword();

	String getSenderHost();

	long getSenderPort();

	String getSubject();

	String getContent();

	String[] getDestinationToEmailAddresses();

	String[] getDestinationCCEmailAddresses();

	String[] getDestinationBCCEmailAddresses();

}