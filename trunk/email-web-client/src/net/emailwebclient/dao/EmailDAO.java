package net.emailwebclient.dao;

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
							"SELECT email_id, e.email_account_id, from_, date, subject, type FROM emails e, email_accounts ea WHERE ea.email_account_id = e.email_account_id AND ea.user_id = ? AND e.type =  ?",
							DAOUtil.getEmailRowMapper(), new Object[] { userId, emailType });
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