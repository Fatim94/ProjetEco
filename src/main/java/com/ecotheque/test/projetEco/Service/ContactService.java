package com.ecotheque.test.projetEco.Service;

import com.ecotheque.test.projetEco.model.Contact;

import java.util.List;

public interface ContactService {
    void create(Contact contact);
    List<Contact> listeContact();
    Contact findByID(Long id);
    void update(Contact contactData, Long id);
    void deleteById(Long id);
}
