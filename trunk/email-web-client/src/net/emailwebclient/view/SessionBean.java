package net.emailwebclient.view;

import javax.faces.event.AbortProcessingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.emailwebclient.model.User;
import net.emailwebclient.view.utils.JSFNavigationConstants;

import com.icesoft.faces.component.paneltabset.TabChangeEvent;
import com.icesoft.faces.component.paneltabset.TabChangeListener;

public class SessionBean implements TabChangeListener {

	private User loggedInUser;

	private int selectedIndex = 0;

	private boolean emailVisible = true;
	private boolean addressBookVisible = true;
	private boolean optionsVisible = true;

	public void processTabChange(TabChangeEvent arg0)
			throws AbortProcessingException {
		// TODO Auto-generated method stub
	}

	public String logout(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();

			loggedInUser = null;

			// invalidate the session & allow icefaces to clean their part
			if (session != null)
				session.invalidate();

			// create a new session
			request.getSession(true);
		} catch (Throwable t) {
			return JSFNavigationConstants.FAIL;
		}
		return JSFNavigationConstants.SUCCESS;
	}

	public User getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(User loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	public int getSelectedIndex() {
		return selectedIndex;
	}

	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
	}

	public boolean isEmailVisible() {
		return emailVisible;
	}

	public void setEmailVisible(boolean emailVisible) {
		this.emailVisible = emailVisible;
	}

	public boolean isAddressBookVisible() {
		return addressBookVisible;
	}

	public void setAddressBookVisible(boolean addressBookVisible) {
		this.addressBookVisible = addressBookVisible;
	}

	public boolean isOptionsVisible() {
		return optionsVisible;
	}

	public void setOptionsVisible(boolean optionsVisible) {
		this.optionsVisible = optionsVisible;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private boolean fisiereVisible = true;
	private boolean profilVisible = true;
	private boolean cautareVisible = true;

	public boolean isCautareVisible() {
		return cautareVisible;
	}

	public void setCautareVisible(boolean cautareVisible) {
		this.cautareVisible = cautareVisible;
	}

	public boolean isProfilVisible() {
		return profilVisible;
	}

	public void setProfilVisible(boolean profilVisible) {
		this.profilVisible = profilVisible;
	}

	public boolean isFisiereVisible() {
		return fisiereVisible;
	}

	public void setFisiereVisible(boolean fisiereVisible) {
		this.fisiereVisible = fisiereVisible;
	}
}