package net.emailwebclient.view.managedbeans.addressbook;

import net.emailwebclient.view.managedbeans.BaseBean;
import net.emailwebclient.view.utils.JSFNavigationConstants;

public class AddressBookBean extends BaseBean {

	@Override
	public String init() {
		return JSFNavigationConstants.ADDRESS_BOOK_PAGE;
	}

}
