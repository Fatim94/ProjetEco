package com.ecotheque.test.projetEco.repository;

import com.ecotheque.test.projetEco.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
