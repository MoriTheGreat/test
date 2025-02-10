package com.example.codingtest.controller;

import com.example.codingtest.enitity.Population;
import com.example.codingtest.service.PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/population")
public class PopulationController {

    @Autowired
    private PopulationService populationService;

    @GetMapping
    public List<Population> getAllPopulation() {
        return populationService.getAllPopulation();
    }

    @GetMapping("/{id}")
    public Population getPopulationById(@PathVariable Long id) {
        return populationService.getPopulationById(id);
    }

    @PostMapping
    public Population createPopulation(@RequestBody Population population) {
        return populationService.createPopulation(population);
    }

    @PutMapping("/{id}")
    public Population updatePopulation(@PathVariable Long id, @RequestBody Population population) {
        return populationService.updatePopulation(id, population);
    }

    @DeleteMapping("/{id}")
    public void deletePopulation(@PathVariable Long id) {
        populationService.deletePopulation(id);
    }
}
