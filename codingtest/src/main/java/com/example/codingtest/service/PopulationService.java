package com.example.codingtest.service;

import com.example.codingtest.enitity.Population;

import java.util.List;

public interface PopulationService {
    List<Population> getAllPopulation();
    Population getPopulationById(Long id);
    Population createPopulation(Population population);
    Population updatePopulation(Long id, Population population);
    void deletePopulation(Long id);
}
