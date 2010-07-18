package net.emailwebclient.view.managedbeans.home;

import net.emailwebclient.view.SessionBean;
import net.emailwebclient.view.managedbeans.BaseBean;
import net.emailwebclient.view.utils.JSFNavigationConstants;
import net.emailwebclient.view.utils.JSFUtil;
import net.emailwebclient.view.utils.SpringUtil;

public class HomeBean extends BaseBean {

	private String orientation = "vertical";
	private int position = 10;

	public String getDraftCount() {
		return String.valueOf(SpringUtil.getServices().getDraftEmails(
				((SessionBean) JSFUtil.getBean(SessionBean.class.getSimpleName())).getLoggedInUser().getUserId()).size());
	}

	public String getTrashCount() {
		return String.valueOf(SpringUtil.getServices().getTrashEmails(
				((SessionBean) JSFUtil.getBean(SessionBean.class.getSimpleName())).getLoggedInUser().getUserId()).size());
	}
	
	public String checkEmail(){
		SpringUtil.getServices().checkEmail(((SessionBean) JSFUtil.getBean(SessionBean.class.getSimpleName())).getLoggedInUser().getUserId());
		
		return null;
	}

	@Override
	public String init() {
		return JSFNavigationConstants.HOME_PAGE;
	}

	// ////////////////////////
	// Getters and setters
	// ////////////////////////

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
}
