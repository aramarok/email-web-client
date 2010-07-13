package net.emailwebclient.view.managedbeans.home;

import net.emailwebclient.view.managedbeans.BaseBean;
import net.emailwebclient.view.utils.JSFNavigationConstants;

public class InboxBean extends BaseBean{
	
	@Override
	public String init() {
		System.out.println("ssssssssss");
		return JSFNavigationConstants.INBOX_PAGE ;
	}
}
