package net.emailwebclient.dao;

import java.util.List;

import net.emailwebclient.model.User;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class UserDAO {

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcTemplate simpleJdbcTemplate;

	public User addUser(User user) {
		int rows = simpleJdbcTemplate
				.update(
						"INSERT INTO users( user_name, password, first_name, last_name, city, age, sex) VALUES(?, ?, ?, ?, ?, ?, ?)",
						new Object[] { user.getUserName(), user.getPassword(),
								user.getFirstName(), user.getLastName(),
								user.getCity(), user.getAge(), user.getSex() });
		if (rows == 1) {
			return user;
		} else {
			return null;
		}
	}

	public User updateUser(User user) {
		int rows = simpleJdbcTemplate
				.update(
						"UPDATE users SET first_name=?, last_name=?, city=?, age=?, sex=? WHERE user_name=?",
						new Object[] { user.getFirstName(), user.getLastName(),
								user.getCity(), user.getAge(), user.getSex(),
								user.getUserName() });
		if (rows == 1) {
			return getUser(user.getUserName());
		} else {
			return null;
		}
	}

	public boolean deleteUser(User user) {
		return false;
	}

	public User getUser(String userName) {
		try {
			return (User) this.simpleJdbcTemplate
					.queryForObject(
							"SELECT USER_ID, user_name, password, first_name, last_name, city, age, sex FROM users WHERE user_name = ?",
							DAOUtil.getUserRowMapper(),
							new Object[] { userName });
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<User> findUsers(User userFilter) {
		StringBuffer query = new StringBuffer(
				"SELECT user_name, password, first_name, last_name, city, age, sex FROM users ");

		if (userFilter != null) {

			String and = " AND ";
			String where = " WHERE ";

			boolean whereAdded = false;
			boolean andNeeded = false;

			if (userFilter.getUserName() != null) {
				if (!whereAdded) {
					query.append(where);
					whereAdded = true;
				}
				if (andNeeded) {
					query.append(and);
				}
				query.append(" user_name LIKE %" + userFilter.getUserName()
						+ "%");
				andNeeded = true;
			}

			if (userFilter.getFirstName() != null) {
				if (!whereAdded) {
					query.append(where);
					whereAdded = true;
				}
				if (andNeeded) {
					query.append(and);
				}
				query.append(" first_name LIKE %" + userFilter.getFirstName()
						+ "%");
				andNeeded = true;
			}

			if (userFilter.getLastName() != null) {
				if (!whereAdded) {
					query.append(where);
					whereAdded = true;
				}
				if (andNeeded) {
					query.append(and);
				}
				query.append(" last_name LIKE %" + userFilter.getLastName()
						+ "%");
				andNeeded = true;
			}

			if (userFilter.getCity() != null) {
				if (!whereAdded) {
					query.append(where);
					whereAdded = true;
				}
				if (andNeeded) {
					query.append(and);
				}
				query.append(" city LIKE %" + userFilter.getCity() + "%");
				andNeeded = true;
			}

			if (userFilter.getSex() != null) {
				if (!whereAdded) {
					query.append(where);
					whereAdded = true;
				}
				if (andNeeded) {
					query.append(and);
				}
				query.append(" sex = " + userFilter.getSex());
				andNeeded = true;
			}
		}

		@SuppressWarnings("unchecked")
		List<User> results = (List<User>) jdbcTemplate.query(query.toString(),
				DAOUtil.getUserRowMapper());
		return results;
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