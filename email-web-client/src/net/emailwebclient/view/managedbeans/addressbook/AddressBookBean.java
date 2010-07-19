package net.emailwebclient.view.managedbeans.addressbook;

import java.util.List;

import javax.faces.event.PhaseId;

import net.emailwebclient.model.Contact;
import net.emailwebclient.view.SessionBean;
import net.emailwebclient.view.managedbeans.BaseBean;
import net.emailwebclient.view.utils.JSFNavigationConstants;
import net.emailwebclient.view.utils.JSFUtil;
import net.emailwebclient.view.utils.SpringUtil;

import com.icesoft.faces.component.ext.RowSelectorEvent;

public class AddressBookBean extends BaseBean {

	private List<Contact> contacts;

	private long contactId;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String info;
	private long userId;

	private boolean sortOrder = true;

	public AddressBookBean() {
	}

	public String init() {
		clearSelection();
		contacts = SpringUtil.getServices().getContacts(((SessionBean) JSFUtil.getBean(SessionBean.class.getSimpleName())).getLoggedInUser().getUserId());

		return JSFNavigationConstants.ADDRESS_BOOK_PAGE;
	}

	private void clearSelection() {
		contactId = -1;
		firstName = null;
		lastName = null;
		emailAddress = null;
		info = null;
		userId = -1;
	}

	private void loadContactData(long contactId) {
		Contact selectedContact = SpringUtil.getServices().getContact(contactId);
		this.contactId = selectedContact.getContactId();
		firstName = selectedContact.getFirstName();
		lastName = selectedContact.getLastName();
		emailAddress = selectedContact.getEmailAddress();
		info = selectedContact.getInfo();
		userId = selectedContact.getUserId();
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

	private void findSelectedElement() {
		for (Contact o : contacts) {
			if (o.isSelected()) {
				loadContactData(o.getContactId());
				break;
			}
		}
	}

	public String addNew() {
		Contact contact = new Contact();
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setInfo(info);
		contact.setEmailAddress(emailAddress);
		contact.setUserId(((SessionBean) JSFUtil.getBean(SessionBean.class.getSimpleName())).getLoggedInUser().getUserId());
		SpringUtil.getServices().addContact(contact);
		init();
		return null;
	}

	public String save() {
		Contact contact = new Contact();
		contact.setContactId(contactId);
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setInfo(info);
		contact.setEmailAddress(emailAddress);
		SpringUtil.getServices().updateContact(contact);
		init();
		return null;
	}

	public String delete() {
		SpringUtil.getServices().deleteContact(contactId);
		init();
		return null;
	}

	// ////////////////////////
	// Getters and setters
	// ////////////////////////

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public boolean isSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(boolean sortOrder) {
		this.sortOrder = sortOrder;
	}

}