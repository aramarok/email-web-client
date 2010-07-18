package net.emailwebclient.bl;

import java.util.List;

import net.emailwebclient.dao.EmailAccountDAO;
import net.emailwebclient.dao.EmailDAO;
import net.emailwebclient.dao.UserDAO;
import net.emailwebclient.dao.tables.EmailTypes;
import net.emailwebclient.email.EMailSender;
import net.emailwebclient.model.Email;
import net.emailwebclient.model.EmailAccount;
import net.emailwebclient.model.User;
import net.emailwebclient.view.managedbeans.home.EMailContent;

public class Services {

	private UserDAO userDAO;
	private EmailAccountDAO emailAccountDAO;
	private EmailDAO emailDAO;

	public User login(String userName, String password) {
		User user = userDAO.getUser(userName);
		if (user != null && user.getPassword().compareTo(password) == 0) {
			return user;
		} else {
			return null;
		}
	}

	public User getUser(String userName) {
		return userDAO.getUser(userName);
	}

	public User updateUser(User user) {
		return userDAO.updateUser(user);
	}

	public EmailAccount addEmailAccount(EmailAccount emailAccount) {
		return emailAccountDAO.addEmailAccount(emailAccount);
	}

	public EmailAccount updateEmailAccount(EmailAccount emailAccount) {
		return emailAccountDAO.updateEmailAccount(emailAccount);
	}

	public EmailAccount getEmailAccount(long emailAccountId) {
		return emailAccountDAO.getEmailAccount(emailAccountId);
	}

	public boolean deleteEmailAccount(long emailAccountId) {
		return emailAccountDAO.deleteEmailAccount(emailAccountId);
	}

	public List<EmailAccount> getEmailAccounts(long userId) {
		return emailAccountDAO.getEmailAccounts(userId);
	}

	public List<Email> getInboxEmails(long userId) {
		return emailDAO.getEmails(userId, EmailTypes.INBOX);
	}

	public List<Email> getSentEmails(long userId) {
		return emailDAO.getEmails(userId, EmailTypes.SENT);
	}

	public List<Email> getDraftEmails(long userId) {
		return emailDAO.getEmails(userId, EmailTypes.DRAFT);
	}

	public List<Email> getTrashEmails(long userId) {
		return emailDAO.getEmails(userId, EmailTypes.TRASH);
	}

	public boolean saveEmailAsDraft(long emailAccountId, Email email) {
		return emailDAO.saveEmailAsDraft(emailAccountId, email);
	}

	public boolean sendEmail(long emailAccountId, EMailContent emailContent) {
		EmailAccount ea = getEmailAccount(emailAccountId);
		emailContent.setHost(ea.getHost());
		emailContent.setPort(ea.getPort());
		emailContent.setPassword(ea.getPassword());
		emailContent.setFrom(ea.getEmailAddress());
		EMailSender.send(emailContent);

		Email email = new Email();
		email.copyFromEMailContentObject(emailContent);
		email.setEmailAccountId(emailAccountId);

		return emailDAO.saveEmailAsSent(emailAccountId, email);
	}

	public Email getEmail(long emailId) {
		return emailDAO.getEmail(emailId);
	}
	
	public boolean checkEmail(long userId){
		return emailDAO.checkEmail(userId);
	}

	// ////////////////////////
	// Getters and setters
	// ////////////////////////

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public EmailAccountDAO getEmailAccountDAO() {
		return emailAccountDAO;
	}

	public void setEmailAccountDAO(EmailAccountDAO emailAccountDAO) {
		this.emailAccountDAO = emailAccountDAO;
	}

	public EmailDAO getEmailDAO() {
		return emailDAO;
	}

	public void setEmailDAO(EmailDAO emailDAO) {
		this.emailDAO = emailDAO;
	}

}