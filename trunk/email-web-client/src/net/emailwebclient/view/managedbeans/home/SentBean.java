package net.emailwebclient.view.managedbeans.home;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.faces.event.PhaseId;

import net.emailwebclient.model.Email;
import net.emailwebclient.view.SessionBean;
import net.emailwebclient.view.managedbeans.BaseBean;
import net.emailwebclient.view.utils.JSFNavigationConstants;
import net.emailwebclient.view.utils.JSFUtil;
import net.emailwebclient.view.utils.SpringUtil;

import com.icesoft.faces.component.ext.RowSelectorEvent;

public class SentBean extends BaseBean {

	private List<Email> emails;

	private String from;
	private String to;
	private String date;
	private String subject;
	private String content;

	private boolean showDetails = false;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

	@Override
	public String init() {
		clearSelection();
		emails = SpringUtil.getServices().getSentEmails(((SessionBean) JSFUtil.getBean(SessionBean.class.getSimpleName())).getLoggedInUser().getUserId());

		return JSFNavigationConstants.SENT_PAGE;
	}

	public void elementRowSelection(RowSelectorEvent e) {
		if (!e.getPhaseId().equals(PhaseId.INVOKE_APPLICATION)) {
			e.setPhaseId(PhaseId.INVOKE_APPLICATION);
			e.queue();
			return;
		}
		clearSelection();
		findSelectedElement();
	}

	private void clearSelection() {
		from = null;
		to = null;
		date = null;
		subject = null;
		content = null;
	}

	private void findSelectedElement() {
		for (Email o : emails) {
			if (o.isSelected()) {
				loadEmailData(o.getEmailId());
				break;
			}
		}
	}

	private void loadEmailData(long emailId) {
		Email selectedEmail = SpringUtil.getServices().getEmail(emailId);
		from = selectedEmail.getFrom();
		to = selectedEmail.getTo();
		date = dateFormat.format(selectedEmail.getDate());
		subject = selectedEmail.getSubject();
		content = selectedEmail.getContent();
	}

	public String showDetails() {
		showDetails = true;
		return null;
	}

	public String hideDetails() {
		showDetails = false;
		return null;
	}

	// ////////////////////////
	// Getters and setters
	// ////////////////////////

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isShowDetails() {
		return showDetails;
	}

	public void setShowDetails(boolean showDetails) {
		this.showDetails = showDetails;
	}

}
