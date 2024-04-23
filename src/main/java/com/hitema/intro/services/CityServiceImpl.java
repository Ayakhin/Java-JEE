package com.hitema.intro.services;

import com.hitema.intro.models.City;

import com.hitema.intro.repositories.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class CityServiceImpl implements CityService{

    private static final Logger log = LoggerFactory.getLogger(CityServiceImpl.class);

    private CityRepository repository;

    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public City create(City city) {
        if ( city.getLastUpdate() == null )
                city.setLastUpdate(LocalDateTime.now());
        return repository.save(city);
    }

    @Override
    public City read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<City> readAll() {
        return repository.findAll();
    }

    @Override
    public List<City> readAllByName(String expr) {
        return repository.findCitiesByNameContaining(expr);
    }

    @Override
    public City update(City city) {
        city.setLastUpdate(LocalDateTime.now());
        return repository.save(city);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return ( read(id) == null ? true : false) ;
    }
}
