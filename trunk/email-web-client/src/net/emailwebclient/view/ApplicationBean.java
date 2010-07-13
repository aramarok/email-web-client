package net.emailwebclient.view;

import java.util.List;

import net.emailwebclient.model.User;


public class ApplicationBean {

	private List<User> loggedInUsers = null;

	public ApplicationBean() {
	}

	public List<User> getLoggedInUsers() {
		return loggedInUsers;
	}

}