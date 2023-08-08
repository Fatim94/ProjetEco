package com.ecotheque.test.projetEco.Service;

import com.ecotheque.test.projetEco.model.Contact;
import com.ecotheque.test.projetEco.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstactServiceImpl implements ContactService{
    private final ContactRepository contactRepository;

    public ConstactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public void create(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public List<Contact> listeContact() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findByID(Long id) {
        return contactRepository.findById(id).get();
    }

    @Override
    public void update(Contact contactData, Long id) {
        var optionalContact=contactRepository.findById(id);
        //Vérifier qu'un contact est dans le
        if(optionalContact.isPresent()){
            var contact=optionalContact.get();
            //Update les données
            contact.setNom(contactData.getNom());
            contact.setEmail(contactData.getEmail());
            contact.setNumeroDeTelephone(contactData.getNumeroDeTelephone());
            contact.setMessage(contactData.getMessage());
            //Sauvegarde en BD
            contactRepository.save(contact);
        }
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);

    }

}
