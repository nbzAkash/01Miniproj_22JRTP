package in.akash.service;

import java.util.List;

import in.akash.binding.Contact;

public interface ContactService {
	
	public String saveContact(Contact contact);
	
	public List<Contact> getAllContact();
	
	public Contact getContactById(Integer contactId);
	
	public String updateContact(Contact contact);
	
	public String deleteContactById(Integer contactId);

}
