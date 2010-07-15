package net.emailwebclient.view.managedbeans.home;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import net.emailwebclient.model.EmailAccount;
import net.emailwebclient.view.SessionBean;
import net.emailwebclient.view.managedbeans.BaseBean;
import net.emailwebclient.view.utils.JSFNavigationConstants;
import net.emailwebclient.view.utils.JSFUtil;
import net.emailwebclient.view.utils.SpringUtil;

public class ComposeEmailBean extends BaseBean {

	private List<EmailAccount> emailAccounts = null;
	private List<SelectItem> emailAccountsAsSelectItem = new ArrayList<SelectItem>();

	private String from;
	private String to;
	private String cc;
	private String bcc;
	private String subject;

	public String getToolbarModeDefault() {
		return "Default";
	}

	public String getToolbarModeBasic() {
		return "Basic";
	}

	private String toolbarMode = getToolbarModeDefault();

	private String value = "";

	@Override
	public String init() {
		emailAccounts = SpringUtil.getServices().getEmailAccounts(
				((SessionBean) JSFUtil.getBean(SessionBean.class
						.getSimpleName())).getLoggedInUser());
		for (EmailAccount ea : emailAccounts) {
			this.emailAccountsAsSelectItem.add(new SelectItem(ea
					.getEmailAccountId(), ea.getEmailAddress()));
		}

		return JSFNavigationConstants.COMPOSE_EMAIL;
	}

	public String send() {
		System.out.println(from);
		return null;
	}

	public String saveAsDraft() {
		System.out.println(from);
		return null;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getToolbarMode() {
		return toolbarMode;
	}

	public void setToolbarMode(String toolbarMode) {
		this.toolbarMode = toolbarMode;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public List<EmailAccount> getEmailAccounts() {
		return emailAccounts;
	}

	public void setEmailAccounts(List<EmailAccount> emailAccounts) {
		this.emailAccounts = emailAccounts;
	}

	public List<SelectItem> getEmailAccountsAsSelectItem() {
		return emailAccountsAsSelectItem;
	}

	public void setEmailAccountsAsSelectItem(
			List<SelectItem> emailAccountsAsSelectItem) {
		this.emailAccountsAsSelectItem = emailAccountsAsSelectItem;
	}

}
