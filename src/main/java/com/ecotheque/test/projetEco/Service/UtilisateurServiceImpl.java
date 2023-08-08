package com.ecotheque.test.projetEco.Service;

import com.ecotheque.test.projetEco.model.Utilisateur;
import com.ecotheque.test.projetEco.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public void create(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);


    }
}
