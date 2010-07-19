package net.emailwebclient.view.managedbeans.home;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import net.emailwebclient.model.Email;
import net.emailwebclient.model.EmailAccount;
import net.emailwebclient.view.SessionBean;
import net.emailwebclient.view.managedbeans.BaseBean;
import net.emailwebclient.view.utils.JSFNavigationConstants;
import net.emailwebclient.view.utils.JSFUtil;
import net.emailwebclient.view.utils.SpringUtil;

public class ComposeEmailBean extends BaseBean {

	private List<EmailAccount> emailAccounts = null;
	private List<SelectItem> emailAccountsAsSelectItem = null;

	private String from;
	private String to;
	private String cc;
	private String bcc;
	private String subject;

	private boolean showCc = false;
	private boolean showBcc = false;

	public String getToolbarModeDefault() {
		return "Default";
	}

	public String getToolbarModeBasic() {
		return "Basic";
	}

	private String toolbarMode = getToolbarModeDefault();

	private String content;

	@Override
	public String init() {
		clearChanges();
		emailAccounts = SpringUtil.getServices().getEmailAccountsToUse(
				((SessionBean) JSFUtil.getBean(SessionBean.class.getSimpleName())).getLoggedInUser().getUserId());
		emailAccountsAsSelectItem = new ArrayList<SelectItem>();
		for (EmailAccount ea : emailAccounts) {
			this.emailAccountsAsSelectItem.add(new SelectItem(ea.getEmailAccountId(), ea.getEmailAddress()));
		}

		return JSFNavigationConstants.COMPOSE_EMAIL;
	}

	public void validateEmails(FacesContext context, UIComponent validate, Object value) {
		String input = (String) value;

		boolean invalid = true;

		String[] emails = input.trim().split(",");
		for (String e : emails) {
			validateEmail(e);
		}

		if (invalid) {
			((UIInput) validate).setValid(false);
			FacesMessage msg = new FacesMessage("Invalid e-mail(s)");
			context.addMessage(validate.getClientId(context), msg);
		}
	}

	private static boolean validateEmail(String emailAddress) {
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

		Matcher m = p.matcher(emailAddress);

		boolean matchFound = m.matches();

		StringTokenizer st = new StringTokenizer(emailAddress, ".");
		String lastToken = null;
		while (st.hasMoreTokens()) {
			lastToken = st.nextToken();
		}

		if (matchFound && lastToken.length() >= 2 && emailAddress.length() - 1 != lastToken.length()) {
			return true;
		} else
			return false;
	}

	public String send() {
		EMailContent ec = new EMailContent(to.trim().split(","), cc.trim().split(","), bcc.trim().split(","), subject, content);
		SpringUtil.getServices().sendEmail(Long.valueOf(from), ec);
		return JSFNavigationConstants.INBOX_PAGE;
	}

	public String saveAsDraft() {
		Email email = new Email();
		email.setTo(to);
		email.setCc(cc);
		email.setBcc(bcc);
		email.setSubject(subject);
		email.setContent(content);
		SpringUtil.getServices().saveEmailAsDraft(Long.valueOf(from), email);
		clearChanges();
		return JSFNavigationConstants.INBOX_PAGE;
	}

	public String discard() {
		clearChanges();
		return JSFNavigationConstants.INBOX_PAGE;
	}

	private void clearChanges() {
		emailAccounts = null;
		emailAccountsAsSelectItem = null;
		from = null;
		to = null;
		cc = null;
		bcc = null;
		subject = null;
		content = null;
		showCc = false;
		showBcc = false;
	}

	public String showCc() {
		showCc = true;
		return null;
	}

	public String showBcc() {
		showBcc = true;
		return null;
	}

	// ////////////////////////
	// Getters and setters
	// ////////////////////////

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public void setEmailAccountsAsSelectItem(List<SelectItem> emailAccountsAsSelectItem) {
		this.emailAccountsAsSelectItem = emailAccountsAsSelectItem;
	}

	public boolean isShowCc() {
		return showCc;
	}

	public void setShowCc(boolean showCc) {
		this.showCc = showCc;
	}

	public boolean isShowBcc() {
		return showBcc;
	}

	public void setShowBcc(boolean showBcc) {
		this.showBcc = showBcc;
	}

}