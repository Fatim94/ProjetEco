package com.ecotheque.test.projetEco;

import com.ecotheque.test.projetEco.model.Contact;
import com.ecotheque.test.projetEco.repository.ContactRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ContactRepositoryTest {
    @Autowired
    private ContactRepository contactRepository;
    @Test
    public void testAddContact(){
        //Given
        var contact= Contact.builder()
                .nom("Farimata Douaré")
                .email("Fat41@gmail.com")
                .numeroDeTelephone("74 25 63 98")
                .message("hi")
                .build();
        //When
        Contact contactSave=contactRepository.save(contact);

        //Then
        assertThat(contactSave).isNotNull();


    }
    @Test
    public void testListAll() {
        Iterable<Contact> contacts = contactRepository.findAll();
        assertThat(contacts).hasSameClassAs(contacts);
        for (Contact contact : contacts) {
            System.out.println(contacts);
        }

    }
    @Test
    public void testUpdate() {
        Long contactId = 10L;
        Optional<Contact> optionalContact = contactRepository.findById(contactId);
        Contact contact = optionalContact.get();
        contact.setNom("Sokpe");
        contactRepository.save(contact);
        //When
        Contact updateContact = contactRepository.findById(contactId).get();
        //Assert
        assertThat(updateContact.getNom()).isEqualTo("Sokpe");

    }
    @Test
    public void testGet(){
        Long contactId = 2L;
        Optional<Contact> optionalContact = contactRepository.findById(contactId);
        assertThat(optionalContact).isPresent();
        System.out.println(optionalContact.get());
    }
    @Test
    public void testDelete(){
        Long contactId = 2L;
        contactRepository.deleteById(contactId);
        Optional<Contact> optionalContact = contactRepository.findById(contactId);
        assertThat(optionalContact).isNotPresent();

    }
}
