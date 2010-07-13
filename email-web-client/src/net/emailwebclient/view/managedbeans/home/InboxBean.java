package net.emailwebclient.view.managedbeans.home;

import java.util.List;

import javax.faces.event.PhaseId;

import com.icesoft.faces.component.ext.RowSelectorEvent;

import net.emailwebclient.model.Email;
import net.emailwebclient.model.User;
import net.emailwebclient.view.managedbeans.BaseBean;
import net.emailwebclient.view.utils.JSFNavigationConstants;
import net.emailwebclient.view.utils.SpringUtil;

public class InboxBean extends BaseBean{
	
	private List<Email> emails;
	
	@Override
	public String init() {
		User u = new User();
		u.setUserId(1);
		emails = SpringUtil.getServices().getInboxEmails(u);
		
		return JSFNavigationConstants.INBOX_PAGE ;
	}

	public void elementRowSelection(RowSelectorEvent e) {
		if (!e.getPhaseId().equals(PhaseId.INVOKE_APPLICATION)) {
			e.setPhaseId(PhaseId.INVOKE_APPLICATION);
			e.queue();
			return;
		}
		//findSelectedElement();
	}
	
	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}
	
}
