package net.emailwebclient.dao;

import java.util.Date;
import java.util.List;

import net.emailwebclient.dao.tables.EmailTypes;
import net.emailwebclient.model.Email;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class EmailDAO {

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcTemplate simpleJdbcTemplate;

	public List<Email> getEmails(long userId, EmailTypes emailType) {
		try {
			return simpleJdbcTemplate
					.query(
							"SELECT e.EMAIL_ID, e.EMAIL_ACCOUNT_ID, e.FROM_, e.REPLY_TO, e.TO_, e.CC, e.BCC, e.DATE, e.SUBJECT, e.CONTENT, e.TYPE FROM emails e, email_accounts ea WHERE ea.email_account_id = e.email_account_id AND ea.user_id = ? AND e.type =  ?",
							DAOUtil.getEmailRowMapper(), new Object[] { userId, EmailTypes.getEmailType(emailType) });
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public boolean saveEmailAsDraft(long emailAccountId, Email email) {
		int rows = simpleJdbcTemplate.update(
				"INSERT INTO emails (EMAIL_ACCOUNT_ID, FROM_, REPLY_TO, TO_, CC, BCC, DATE, SUBJECT, CONTENT, TYPE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] { emailAccountId, email.getFrom(), email.getReplyTo(), email.getTo(), email.getCc(), email.getBcc(), new Date(),
						email.getSubject(), email.getContent(), EmailTypes.getEmailType(EmailTypes.DRAFT) });
		if (rows == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean saveEmailAsSent(long emailAccountId, Email email) {
		int rows = simpleJdbcTemplate.update(
				"INSERT INTO emails (EMAIL_ACCOUNT_ID, FROM_, REPLY_TO, TO_, CC, BCC, DATE, SUBJECT, CONTENT, TYPE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] { email.getEmailAccountId(), email.getFrom(), email.getReplyTo(), email.getTo(), email.getCc(), email.getBcc(), new Date(),
						email.getSubject(), email.getContent(), EmailTypes.getEmailType(EmailTypes.SENT) });
		if (rows == 1) {
			return true;
		} else {
			return false;
		}
	}

	public Email getEmail(long emailId) {
		try {
			return this.simpleJdbcTemplate.queryForObject(
					"SELECT EMAIL_ID, EMAIL_ACCOUNT_ID, FROM_, REPLY_TO, TO_, CC, BCC, DATE, SUBJECT, CONTENT, TYPE FROM emails WHERE EMAIL_ID = ?", DAOUtil
							.getEmailRowMapper(), new Object[] { emailId });
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	// ////////////////////////
	// Getters and setters
	// ////////////////////////

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