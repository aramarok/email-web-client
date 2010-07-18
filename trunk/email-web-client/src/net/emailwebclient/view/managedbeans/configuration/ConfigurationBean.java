package net.emailwebclient.view.managedbeans.configuration;

import java.util.List;

import javax.faces.event.PhaseId;

import net.emailwebclient.model.EmailAccount;
import net.emailwebclient.view.SessionBean;
import net.emailwebclient.view.managedbeans.BaseBean;
import net.emailwebclient.view.utils.JSFNavigationConstants;
import net.emailwebclient.view.utils.JSFUtil;
import net.emailwebclient.view.utils.SpringUtil;

import com.icesoft.faces.component.ext.RowSelectorEvent;

public class ConfigurationBean extends BaseBean {

	private List<EmailAccount> accounts;

	private long emailAccountId;
	private String protocol;
	private String host;
	private long port;
	private String userName;
	private String password;
	private String emailAddress;
	private boolean useEmailAccount;

	private String emailAddressColumn ="emailAddressColumn";
	private String hostColumn = "hostColumn";
	private String protocolColumn = "protocolColumn";
	private String sortColumn = "emailAddressColumn";
	private boolean sortOrder = true;

	public ConfigurationBean() {
		// init();
	}

	public String init() {
		
		accounts = SpringUtil.getServices().getEmailAccounts(((SessionBean)JSFUtil.getBean(SessionBean.class.getSimpleName())).getLoggedInUser().getUserId());

		return JSFNavigationConstants.CONFIGURATION_PAGE;
	}

	private void loadAccountData(long emailAccountId) {
		EmailAccount selectedAccount = SpringUtil.getServices()
				.getEmailAccount(emailAccountId);
		this.protocol = selectedAccount.getProtocol();
		this.host = selectedAccount.getHost();
		this.port = selectedAccount.getPort();
		this.userName = selectedAccount.getUserName();
		this.password = selectedAccount.getPassword();
		this.emailAddress = selectedAccount.getEmailAddress();
		this.useEmailAccount = selectedAccount.isUseEmailAccount();
	}

	public void elementRowSelection(RowSelectorEvent e) {
		if (!e.getPhaseId().equals(PhaseId.INVOKE_APPLICATION)) {
			e.setPhaseId(PhaseId.INVOKE_APPLICATION);
			e.queue();
			return;
		}
		findSelectedElement();
	}

	private void findSelectedElement() {

		for (EmailAccount o : accounts) {
			if (o.isSelected()) {
				loadAccountData(o.getEmailAccountId());
				break;
			}
		}
	}

	public String addNew() {
		return null;
	}

	public String save() {
		return null;
	}

	public String delete() {
		return null;
	}

	public List<EmailAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<EmailAccount> accounts) {
		this.accounts = accounts;
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

	public long getPort() {
		return port;
	}

	public void setPort(long port) {
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

	public boolean isUseEmailAccount() {
		return useEmailAccount;
	}

	public void setUseEmailAccount(boolean useEmailAccount) {
		this.useEmailAccount = useEmailAccount;
	}

	public String getHostColumn() {
		return hostColumn;
	}

	public void setHostColumn(String hostColumn) {
		this.hostColumn = hostColumn;
	}

	public String getProtocolColumn() {
		return protocolColumn;
	}

	public void setProtocolColumn(String protocolColumn) {
		this.protocolColumn = protocolColumn;
	}

	public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	public boolean isSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(boolean sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailAddressColumn() {
		return emailAddressColumn;
	}

	public void setEmailAddressColumn(String emailAddressColumn) {
		this.emailAddressColumn = emailAddressColumn;
	}

}