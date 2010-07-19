package net.emailwebclient.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.emailwebclient.dao.tables.ContactsTable;
import net.emailwebclient.dao.tables.EmailAccountTable;
import net.emailwebclient.dao.tables.EmailTable;
import net.emailwebclient.dao.tables.EmailTypes;
import net.emailwebclient.dao.tables.UsersTable;
import net.emailwebclient.model.Contact;
import net.emailwebclient.model.Email;
import net.emailwebclient.model.EmailAccount;
import net.emailwebclient.model.User;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class DAOUtil {

	public static ParameterizedRowMapper<User> getUserRowMapper() {
		return new ParameterizedRowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUserId(rs.getLong(UsersTable.USER_ID.getName()));
				user.setUserName(rs.getString(UsersTable.USER_NAME.getName()));
				user.setPassword(rs.getString(UsersTable.PASSWORD.getName()));
				user.setLastName(rs.getString(UsersTable.LAST_NAME.getName()));
				user.setFirstName(rs.getString(UsersTable.FIRST_NAME.getName()));
				user.setCity(rs.getString(UsersTable.CITY.getName()));
				user.setAge(Integer.parseInt(rs.getString(UsersTable.AGE.getName())));
				user.setSex(Integer.parseInt(rs.getString(UsersTable.SEX.getName())));
				return user;
			}
		};
	}

	public static ParameterizedRowMapper<EmailAccount> getEmailAccountRowMapper() {
		return new ParameterizedRowMapper<EmailAccount>() {
			public EmailAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmailAccount emailAccount = new EmailAccount();
				emailAccount.setEmailAccountId(rs.getLong(EmailAccountTable.EMAIL_ACCOUNT_ID.getName()));
				emailAccount.setProtocol(rs.getString(EmailAccountTable.PROTOCOL.getName()));
				emailAccount.setHost(rs.getString(EmailAccountTable.HOST.getName()));
				emailAccount.setPort(rs.getLong(EmailAccountTable.PORT.getName()));
				emailAccount.setUserName(rs.getString(EmailAccountTable.USER_NAME.getName()));
				emailAccount.setPassword(rs.getString(EmailAccountTable.PASSWORD.getName()));
				emailAccount.setEmailAddress(rs.getString(EmailAccountTable.EMAIL_ADDRESS.getName()));
				emailAccount.setUserId(rs.getLong(EmailAccountTable.USER_ID.getName()));
				emailAccount.setUseEmailAccount(rs.getBoolean(EmailAccountTable.USE_EMAIL_ACCOUNT.getName()));
				return emailAccount;
			}
		};
	}

	public static ParameterizedRowMapper<Email> getEmailRowMapper() {
		return new ParameterizedRowMapper<Email>() {
			public Email mapRow(ResultSet rs, int rowNum) throws SQLException {
				Email email = new Email();
				email.setEmailId(rs.getLong(EmailTable.EMAIL_ID.getName()));
				email.setEmailAccountId(rs.getLong(EmailTable.EMAIL_ACCOUNT_ID.getName()));
				email.setFrom(rs.getString(EmailTable.FROM_.getName()));
				email.setReplyTo(rs.getString(EmailTable.REPLY_TO.getName()));
				email.setTo(rs.getString(EmailTable.TO_.getName()));
				email.setCc(rs.getString(EmailTable.CC.getName()));
				email.setBcc(rs.getString(EmailTable.BCC.getName()));
				email.setDate(rs.getDate(EmailTable.DATE.getName()));
				email.setSubject(rs.getString(EmailTable.SUBJECT.getName()));
				email.setContent(rs.getString(EmailTable.CONTENT.getName()));
				email.setType(EmailTypes.getEmailType(rs.getInt(EmailTable.TYPE.getName())));
				return email;
			}
		};
	}

	public static ParameterizedRowMapper<Contact> getContactRowMapper() {
		return new ParameterizedRowMapper<Contact>() {
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Contact contact = new Contact();
				contact.setContactId(rs.getLong(ContactsTable.CONTACT_ID.getName()));
				contact.setFirstName(rs.getString(ContactsTable.FIRST_NAME.getName()));
				contact.setLastName(rs.getString(ContactsTable.LAST_NAME.getName()));
				contact.setEmailAddress(rs.getString(ContactsTable.EMAIL_ADDRESS.getName()));
				contact.setInfo(rs.getString(ContactsTable.INFO.getName()));
				contact.setUserId(rs.getLong(ContactsTable.USER_ID.getName()));
				return contact;
			}
		};
	}

}