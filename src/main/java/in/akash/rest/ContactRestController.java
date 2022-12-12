package in.akash.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.akash.binding.Contact;
import in.akash.service.ContactService;

@RestController
public class ContactRestController {
	@Autowired
	private ContactService service;
	
	// Post ==> http:localhost:8080/contact/
	@PostMapping("/contact")
	public String createContact(@RequestBody Contact contact) {
		String status = service.saveContact(contact);
		return status;
	}
	// Get ==> http:localhost:8080/contacts
    @GetMapping("/contacts")
	public List<Contact> getAllContacts(){
		return service.getAllContact();
	}
    // Get ==> http:localhost:8080/contact/101
    @GetMapping("/contact/{contactId}")
    public Contact getContactById(@PathVariable Integer contactId) {
    	return service.getContactById(contactId);
    
    }
    // Put ==> http:localhost:8080/contact/
    @PutMapping("/contact")
    public String updateContact(@RequestBody Contact contact) {
    	return service.updateContact(contact);
    }
    
    // Delete ==> http:localhost:8080/contact/101
    @DeleteMapping("/contact/{contactId}")
    public String deleteContact(@PathVariable Integer contactId) {
    	return service.deleteContactById(contactId);
    }
} 
