package net.emailwebclient.view.managedbeans.home;

import net.emailwebclient.view.managedbeans.BaseBean;
import net.emailwebclient.view.utils.JSFNavigationConstants;

public class ComposeEmailBean extends BaseBean {

	private String to;
	private String cc;
	private String bcc;
	private String subject;
	
    public String getToolbarModeDefault() { return "Default"; }
    public String getToolbarModeBasic() { return "Basic"; }
    
    private String toolbarMode = getToolbarModeDefault();

    private String value = "";

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
    
	@Override
	public String init() {
		return JSFNavigationConstants.COMPOSE_EMAIL;
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

}
