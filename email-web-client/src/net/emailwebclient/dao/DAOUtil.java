package net.emailwebclient.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.emailwebclient.dao.tables.EmailAccountTable;
import net.emailwebclient.dao.tables.EmailTable;
import net.emailwebclient.dao.tables.UsersTable;
import net.emailwebclient.model.Email;
import net.emailwebclient.model.EmailAccount;
import net.emailwebclient.model.User;

import org.springframework.jdbc.core.RowMapper;


public class DAOUtil {

	public static RowMapper getUserRowMapper() {
		return new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
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
	
	public static RowMapper getEmailAccountRowMapper() {
		return new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmailAccount emailAccount = new EmailAccount();
				emailAccount.setEmailAccountId(rs.getLong(EmailAccountTable.EMAIL_ACCOUNT_ID.getName()));
				emailAccount.setProtocol(rs.getString(EmailAccountTable.PORT.getName()));
				emailAccount.setHost(rs.getString(EmailAccountTable.HOST.getName()));
				emailAccount.setPort(rs.getInt(EmailAccountTable.PORT.getName()));
				emailAccount.setUserName(rs.getString(EmailAccountTable.USER_NAME.getName()));
				emailAccount.setPassword(rs.getString(EmailAccountTable.PASSWORD.getName()));
				emailAccount.setUserId(rs.getLong(EmailAccountTable.USER_ID.getName()));
				emailAccount.setUseEmailAccount(rs.getBoolean(EmailAccountTable.USE_EMAIL_ACCOUNT.getName()));
				return emailAccount;
			}
		};
	}
	
	public static RowMapper getEmailRowMapper() {
		return new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Email email = new Email();
				email.setEmailId(rs.getLong(EmailTable.EMAIL_ID.getName()));
				email.setEmailAccountId(rs.getLong(EmailTable.EMAIL_ACCOUNT_ID.getName()));
				email.setFrom(rs.getString(EmailTable.FROM_.getName()));
				email.setDate(rs.getDate(EmailTable.DATE.getName()));
				email.setSubject(rs.getString(EmailTable.SUBJECT.getName()));
				return email;
			}
		};
	}

}