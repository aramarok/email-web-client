package net.emailwebclient.dao;

import java.util.List;

import net.emailwebclient.model.EmailAccount;
import net.emailwebclient.model.User;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class EmailAccountDAO {

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcTemplate simpleJdbcTemplate;

	// public EmailAccount addEmailAccount(EmailAccount emailAccount) {
	// int rows = jdbcTemplate
	// .update(
	// //
	// "INSERT INTO email_accounts(email_account_id, password, first_name, last_name, city, age, sex) VALUES(?, ?, ?, ?, ?, ?, ?)",
	// "INSERT INTO email_accounts(EMAIL_ACCOUNT_ID,PROTOCOL,HOST,PORT,USER_NAME,PASSWORD,USER_ID,USE_EMAIL_ACCOUNT) VALUES(?,?,?,?,?,?,?,?)",
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
			return this.simpleJdbcTemplate
					.queryForObject(
							"SELECT email_account_id, protocol, host, port, user_name, password, EMAIL_ADDRESS, user_id, use_email_account FROM email_accounts WHERE email_account_id = ?",
							DAOUtil.getEmailAccountRowMapper(),
							new Object[] { emailAccountId });
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<EmailAccount> getEmailAccounts(User userFilter) {
		try {
			return this.simpleJdbcTemplate
					.query(
							"SELECT email_account_id, protocol, host, port, user_name, password, EMAIL_ADDRESS, user_id, use_email_account FROM email_accounts WHERE user_id = ?",
							DAOUtil.getEmailAccountRowMapper(),
							new Object[] { userFilter.getUserId() });
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

	public SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}

	public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate) {
		this.simpleJdbcTemplate = simpleJdbcTemplate;
	}
}
