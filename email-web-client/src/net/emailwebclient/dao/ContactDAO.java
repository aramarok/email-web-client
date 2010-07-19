package net.emailwebclient.dao;

import java.util.List;

import net.emailwebclient.model.Contact;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class ContactDAO {

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcTemplate simpleJdbcTemplate;

	public Contact addContact(Contact contact) {
		int rows = simpleJdbcTemplate.update("INSERT INTO contacts (FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, INFO, USER_ID) VALUES (?, ?, ?, ? , ?)",
				new Object[] { contact.getFirstName(), contact.getLastName(), contact.getEmailAddress(), contact.getInfo(), contact.getUserId() });
		if (rows == 1) {
			return contact;
		} else {
			return null;
		}
	}

	public Contact updateContact(Contact contact) {
		int rows = simpleJdbcTemplate.update("UPDATE contacts SET FIRST_NAME=?, LAST_NAME=?, EMAIL_ADDRESS=?, INFO=? WHERE CONTACT_ID=?", new Object[] {
				contact.getFirstName(), contact.getLastName(), contact.getEmailAddress(), contact.getInfo(), contact.getContactId() });
		if (rows == 1) {
			return getContact(contact.getContactId());
		} else {
			return null;
		}
	}

	public boolean deleteContact(long contactId) {
		int rows = simpleJdbcTemplate.update("DELETE FROM contacts where CONTACT_ID=?", new Object[] { contactId });
		if (rows == 1) {
			return true;
		} else {
			return false;
		}
	}

	public Contact getContact(long contactId) {
		try {
			return this.simpleJdbcTemplate.queryForObject(
					"SELECT CONTACT_ID, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, INFO, USER_ID FROM contacts WHERE CONTACT_ID = ?", DAOUtil.getContactRowMapper(),
					new Object[] { contactId });
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<Contact> getContacts(long userId) {
		try {
			return this.simpleJdbcTemplate.query("SELECT CONTACT_ID, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, INFO, USER_ID FROM contacts WHERE user_id = ? ORDER BY CONTACT_ID DESC",
					DAOUtil.getContactRowMapper(), new Object[] { userId });
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
