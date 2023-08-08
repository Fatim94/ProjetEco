package com.ecotheque.test.projetEco.Service;

import com.ecotheque.test.projetEco.model.Cours;
import com.ecotheque.test.projetEco.repository.CoursRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoursServiceImpl implements CoursService{
    private final CoursRepository coursRepository;

    public CoursServiceImpl(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    @Override
    public void create(Cours cours) {
        coursRepository.save(cours);
    }

    @Override
    public List<Cours> listCours() {
        return coursRepository.findAll();
    }

    @Override
    public void update(Cours coursData, Long id) {


    }

    @Override
    public Cours findById(Long id) {
        return coursRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
         coursRepository.deleteById(id);

    }
}
