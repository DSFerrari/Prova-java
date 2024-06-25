package com.prova.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova.prova.entities.Cidade;

public interface CityRepository extends JpaRepository<Cidade,Integer> {
    
}
