package com.example.superhelte5.controller;
import com.example.superhelte5.dto.DTOCreationYear;
import com.example.superhelte5.dto.DTOHeroForm;
import com.example.superhelte5.dto.DTOHeroPowers;
import com.example.superhelte5.repository.InterfaceHeroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/hero")
@Controller
public class HeroController {
    InterfaceHeroRepository interfaceHeroRepository;

    public HeroController(ApplicationContext context, @Value("${superhero.repository.impl}") String impl){
        interfaceHeroRepository = (InterfaceHeroRepository) context.getBean(impl);
    }

    @GetMapping()
    public String getHeroInformation(Model model) {
        List<DTOCreationYear> heroList = interfaceHeroRepository.getHeroInfo();
        model.addAttribute("heroList", heroList);
        return "index";
    }

    @GetMapping("superpower/{name}")
    public String getHeroPowers(@PathVariable String name, Model model){
        DTOHeroPowers superheroPowers = interfaceHeroRepository.getHeroPower(name);
        model.addAttribute("name", superheroPowers.getHeroName());
        model.addAttribute("powers", superheroPowers.getHeroPower());
        return "powers";
    }

    @GetMapping("/create")
    public String createSuperhero(Model model){
        DTOHeroForm superheroForm = new DTOHeroForm();
        model.addAttribute("superheroForm", superheroForm);

        List<String> cityList = interfaceHeroRepository.getCities();
        model.addAttribute("cityList", cityList);

        List<String> powerList = interfaceHeroRepository.getPowers();
        model.addAttribute("powerList", powerList);

        return "addSuperhero";
    }

    @PostMapping("/add")
    public String createSuperhero(@ModelAttribute DTOHeroForm superhero){
        interfaceHeroRepository.addSuperHero(superhero);
        return "redirect:/superhero";
    }

    // No finished
    @GetMapping("/update/{name}")
    public String updateSuperhero(@ModelAttribute DTOHeroForm superhero){
        return "updateSuperhero";
    }

}
