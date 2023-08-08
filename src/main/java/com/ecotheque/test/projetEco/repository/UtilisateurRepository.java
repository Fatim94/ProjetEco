package com.ecotheque.test.projetEco.repository;

import com.ecotheque.test.projetEco.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long>{
}
