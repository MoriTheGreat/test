package com.example.codingtest.repository;


import com.example.codingtest.enitity.Population;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopulationRepository extends JpaRepository<Population, Long> {
}
