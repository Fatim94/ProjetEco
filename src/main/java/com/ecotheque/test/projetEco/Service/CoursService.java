package com.ecotheque.test.projetEco.Service;

import com.ecotheque.test.projetEco.model.Cours;

import java.util.List;

public interface CoursService {
   void create(Cours cours);
   List<Cours>listCours();
   void update(Cours coursData,Long id);
   Cours findById(Long id);
   void delete(Long id);

}
