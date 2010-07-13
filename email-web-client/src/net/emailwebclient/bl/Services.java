package net.emailwebclient.bl;

import java.util.List;

import net.emailwebclient.dao.EmailAccountDAO;
import net.emailwebclient.dao.UserDAO;
import net.emailwebclient.model.EmailAccount;
import net.emailwebclient.model.User;

public class Services {

	private UserDAO userDAO;
	private EmailAccountDAO emailAccountDAO;

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

	public EmailAccount getEmailAccount(long emailAccountId) {
		return emailAccountDAO.getEmailAccount(emailAccountId);
	}

	public List<EmailAccount> getEmailAccounts(User userFilter) {
		return emailAccountDAO.getEmailAccounts(userFilter);
	}

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

}