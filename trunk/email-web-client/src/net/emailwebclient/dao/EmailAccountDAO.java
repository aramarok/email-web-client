package net.emailwebclient.dao;

import java.util.List;

import net.emailwebclient.model.EmailAccount;
import net.emailwebclient.model.User;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmailAccountDAO {

	private JdbcTemplate jdbcTemplate;

	// public EmailAccount addEmailAccount(EmailAccount emailAccount) {
	// int rows = jdbcTemplate
	// .update(
	// "INSERT INTO email_accounts(email_account_id, password, first_name, last_name, city, age, sex) VALUES(?, ?, ?, ?, ?, ?, ?)",
	// new Object[] { user.getUserName(), user.getPassword(),
	// user.getFirstName(), user.getLastName(),
	// user.getCity(), user.getAge(), user.getSex() });
	// if (rows == 1) {
	// return user;
	// } else {
	// return null;
	// }
	// }

	// public User updateUser(User user) {
	// int rows = jdbcTemplate
	// .update(
	// "UPDATE users SET first_name=?, last_name=?, city=?, age=?, sex=? WHERE user_name=?",
	// new Object[] { user.getFirstName(), user.getLastName(),
	// user.getCity(), user.getAge(), user.getSex(),
	// user.getUserName() });
	// if (rows == 1) {
	// return getUser(user.getUserName());
	// } else {
	// return null;
	// }
	// }
	//
	// public boolean deleteUser(User user) {
	// return false;
	// }

	public EmailAccount getEmailAccount(long emailAccountId) {
		try {
			return (EmailAccount) this.jdbcTemplate
					.queryForObject(
							"SELECT email_account_id, protocol, host, port, user_name, password, user_id, use_email_account FROM email_accounts WHERE email_account_id = ?",
							new Object[] { emailAccountId }, DAOUtil
									.getEmailAccountRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<EmailAccount> getEmailAccounts(User userFilter) {
		try {
			return (List<EmailAccount>) this.jdbcTemplate
					.query(
							"SELECT email_account_id, protocol, host, port, user_name, password, user_id, use_email_account FROM email_accounts WHERE user_id = ?",
							new Object[] { userFilter.getUserId() }, DAOUtil
									.getEmailAccountRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
