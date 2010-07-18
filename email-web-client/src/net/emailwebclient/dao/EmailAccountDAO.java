package net.emailwebclient.dao;

import java.util.List;

import net.emailwebclient.model.EmailAccount;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class EmailAccountDAO {

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcTemplate simpleJdbcTemplate;

	public EmailAccount addEmailAccount(EmailAccount emailAccount) {
		int rows = simpleJdbcTemplate
				.update(
						"INSERT INTO email_accounts (PROTOCOL, HOST, PORT, USER_NAME, PASSWORD, EMAIL_ADDRESS, USER_ID, USE_EMAIL_ACCOUNT) VALUES (?, ?, ?, ? , ?, ?, ?, ?)",
						new Object[] { emailAccount.getProtocol(), emailAccount.getHost(), emailAccount.getUserName(), emailAccount.getPassword(),
								emailAccount.getEmailAddress(), emailAccount.getUserId(), emailAccount.isUseEmailAccount() });
		if (rows == 1) {
			return emailAccount;
		} else {
			return null;
		}
	}

	public EmailAccount updateEmailAccount(EmailAccount emailAccount) {
		int rows = simpleJdbcTemplate.update(
				"UPDATE email_accounts SET PROTOCOL=?, HOST=?,PORT=?, USER_NAME=?, PASSWORD=?, EMAIL_ADDRESS=?, USE_EMAIL_ACCOUNT=? WHERE EMAIL_ACCOUNT_ID=?",
				new Object[] { emailAccount.getProtocol(), emailAccount.getHost(), emailAccount.getUserName(), emailAccount.getPassword(),
						emailAccount.getEmailAddress(), emailAccount.isUseEmailAccount(), emailAccount.getEmailAccountId() });
		if (rows == 1) {
			return getEmailAccount(emailAccount.getEmailAccountId());
		} else {
			return null;
		}
	}

	public boolean deleteEmailAccount(long emailAccountId) {
		int rows = simpleJdbcTemplate.update("delete from email_accounts where EMAIL_ACCOUNT_ID=?", new Object[] { emailAccountId });
		if (rows == 1) {
			return true;
		} else {
			return false;
		}
	}

	public EmailAccount getEmailAccount(long emailAccountId) {
		try {
			return this.simpleJdbcTemplate
					.queryForObject(
							"SELECT email_account_id, protocol, host, port, user_name, password, EMAIL_ADDRESS, user_id, use_email_account FROM email_accounts WHERE email_account_id = ?",
							DAOUtil.getEmailAccountRowMapper(), new Object[] { emailAccountId });
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<EmailAccount> getEmailAccounts(long userId) {
		try {
			return this.simpleJdbcTemplate
					.query(
							"SELECT email_account_id, protocol, host, port, user_name, password, EMAIL_ADDRESS, user_id, use_email_account FROM email_accounts WHERE user_id = ?",
							DAOUtil.getEmailAccountRowMapper(), new Object[] { userId });
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
