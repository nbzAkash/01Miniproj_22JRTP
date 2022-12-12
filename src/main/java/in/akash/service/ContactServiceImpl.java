package in.akash.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.akash.binding.Contact;
import in.akash.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository repo;

	@Override
	public String saveContact(Contact contact) {
		contact = repo.save(contact);
		
		if(contact.getContactId() != null) {
			return "Contact Saved !!";
		}else {
			return "Contact Failed to Save";
		}
	}

	@Override
	public List<Contact> getAllContact() {
		return repo.findAll();
		
	}

	@Override
	public Contact getContactById(Integer contactId) {
		
		Optional<Contact> findById = repo.findById(contactId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public String updateContact(Contact contact) {
		if(repo.existsById(contact.getContactId())) {
			repo.save(contact); // Update Operation
			return "Update Success";
		}else {
			return "No Record Found";
		}
	}

	@Override
	public String deleteContactById(Integer contactId) {
		if(repo.existsById(contactId)) {
			repo.deleteById(contactId);
			return "Contact Deleted";
		}else {
			return "No Record Found";
		}
		
	}

}
