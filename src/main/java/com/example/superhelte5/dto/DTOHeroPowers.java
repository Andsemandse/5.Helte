package com.example.superhelte5.dto;

import java.util.List;

public class DTOHeroPowers {
    private String heroName;
    private List<String> heroPowerList;

    public DTOHeroPowers(String heroName, List<String> heroPowerList) {
        this.heroName = heroName;
        this.heroPowerList = heroPowerList;
    }

    public String getHeroName() {
        return heroName;
    }

    public List<String> getHeroPower() {
        return heroPowerList;
    }

    public void addHeroPower(String superpower) {
        heroPowerList.add(superpower);
    }
}

