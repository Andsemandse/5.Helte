package com.example.superhelte5.dto;

public class DTOCreationYear {
    private String heroName;
    private String realName;
    private String creationYear;

    public DTOCreationYear(String heroName, String realName, String creationYear) {
        this.heroName = heroName;
        this.realName = realName;
        this.creationYear = creationYear;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }

    public String getCreationYear() {
        return creationYear;
    }
}