package in.akash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.akash.binding.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
