package com.example.codingtest.service;

import com.example.codingtest.enitity.Population;
import com.example.codingtest.repository.PopulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PopulationServiceImpl implements PopulationService{
    @Autowired
    private PopulationRepository populationRepository;

    @Override
    public List<Population> getAllPopulation() {
        return populationRepository.findAll();
    }

    @Override
    public Population getPopulationById(Long id) {
        Optional<Population> population = populationRepository.findById(id);
        return population.orElse(null);
    }

    @Override
    public Population createPopulation(Population population) {
        return populationRepository.save(population);
    }

    @Override
    public Population updatePopulation(Long id, Population population) {
        if (populationRepository.existsById(id)) {
            population.setId(id);
            return populationRepository.save(population);
        }
        return null;
    }

    @Override
    public void deletePopulation(Long id) {
        populationRepository.deleteById(id);
    }
}
