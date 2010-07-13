public class MainRecieve {

	/** Creates a new instance of Main */
	public MainRecieve() {
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		try {

			GmailUtilities gmail = new GmailUtilities();
			gmail.setUserPass("USERNAME@gmail.com", "PASSWORD");
			gmail.connect();
			gmail.openFolder("INBOX");

			int totalMessages = gmail.getMessageCount();
			int newMessages = gmail.getNewMessageCount();

			System.out.println("Total messages = " + totalMessages);
			System.out.println("New messages = " + newMessages);
			System.out.println("-------------------------------");

			// Uncomment the below line to print the body of the message.
			// Remember it will eat-up your bandwidth if you have 100's of
			// messages. //gmail.printAllMessageEnvelopes();
			gmail.printAllMessages();

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}

	}

}