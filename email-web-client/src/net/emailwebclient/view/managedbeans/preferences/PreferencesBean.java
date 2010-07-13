package net.emailwebclient.view.managedbeans.preferences;

import net.emailwebclient.view.managedbeans.BaseBean;
import net.emailwebclient.view.utils.JSFNavigationConstants;

public class PreferencesBean extends BaseBean {
	@Override
	public String init() {
		return JSFNavigationConstants.PREFERENCES_PAGE;
	}
}
