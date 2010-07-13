package net.emailwebclient.dao;

import java.util.List;

import net.emailwebclient.model.Email;
import net.emailwebclient.model.User;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmailDAO {

	private JdbcTemplate jdbcTemplate;
	

	@SuppressWarnings("unchecked")
	public List<Email> getInboxEmails(User userFilter) {
		try {
			return (List<Email>) this.jdbcTemplate
					.query(
							"SELECT email_id, e.email_account_id, from_, date, subject FROM emails e, email_accounts ea WHERE ea.email_account_id = e.email_account_id AND ea.user_id = ?",
							new Object[] { userFilter.getUserId() }, DAOUtil
									.getEmailRowMapper());
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
