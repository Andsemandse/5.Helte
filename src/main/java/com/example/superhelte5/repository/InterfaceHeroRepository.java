package com.example.superhelte5.repository;

import com.example.superhelte5.dto.DTOCreationYear;
import com.example.superhelte5.dto.DTOHeroForm;
import com.example.superhelte5.dto.DTOHeroPowers;

import java.util.List;


public class InterfaceHeroRepository {

    List<DTOCreationYear> getHeroInfo();

    DTOHeroPowers getHeroPower(String name);

    List<String> getCities();

    List<String> getPowers();

    void addSuperHero(DTOHeroForm form);

    void editHero();
}
