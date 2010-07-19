package net.emailwebclient.email;


public class EMailReciever {

	public static void recieve(String user, String password) {
		try {
			GmailUtilities gmail = new GmailUtilities();
			gmail.setUserPass(user, password);
			gmail.setOther("pop3", "pop.gmail.com", 995);

			gmail.connect();

			gmail.openFolder("INBOX");

			int totalMessages = gmail.getMessageCount();
			int newMessages = gmail.getNewMessageCount();

			System.out.println("Total messages = " + totalMessages);
			System.out.println("New messages = " + newMessages);
			System.out.println("-------------------------------");

			// gmail.printAllMessageEnvelopes();
			gmail.printAllMessages();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}