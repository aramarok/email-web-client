package net.emailwebclient.email;

import java.util.List;

public interface EMail {

	String getSenderEmailAddress();

	String getSenderEmailPassword();

	String getSenderHost();

	int getSenderPort();

	String getSubject();

	String getContent();

	String[] getDestinationToEmailAddresses();

	String[] getDestinationCCEmailAddresses();

	String[] getDestinationBCCEmailAddresses();

}