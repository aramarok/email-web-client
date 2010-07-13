package net.emailwebclient.model;

public final class EmailAccount {

	private long emailAccountId;
	private String protocol;
	private String host;
	private int port;
	private String userName;
	private String password;
	private long userId;
	private boolean useEmailAccount;
	
	private boolean selected; // for UI selection

	public long getEmailAccountId() {
		return emailAccountId;
	}

	public void setEmailAccountId(long emailAccountId) {
		this.emailAccountId = emailAccountId;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public boolean isUseEmailAccount() {
		return useEmailAccount;
	}

	public void setUseEmailAccount(boolean useEmailAccount) {
		this.useEmailAccount = useEmailAccount;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}