package net.emailwebclient.view.managedbeans.home;

import net.emailwebclient.view.managedbeans.BaseBean;
import net.emailwebclient.view.utils.JSFNavigationConstants;

public class HomeBean extends BaseBean {

	private String orientation = "vertical";
    private int position = 10;
    
	@Override
	public String init() {
		return JSFNavigationConstants.HOME_PAGE;
	}
	
	public String checkEmail(){
		return null;
	}

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
