package com.ecotheque.test.projetEco.repository;

import com.ecotheque.test.projetEco.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours,Long> {
}
