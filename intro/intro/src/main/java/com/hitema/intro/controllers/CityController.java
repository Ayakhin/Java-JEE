package com.hitema.intro.controllers;

import com.hitema.intro.models.City;
import com.hitema.intro.services.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/cities")
public class CityController {
    private static final Logger log = LoggerFactory.getLogger(CityController.class);

    private CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping("/all")
    List<City> getAll(){
        return service.readAll();
    }

    @GetMapping("/{id}")
    City getOne(@PathVariable Long id){
        return service.read(id);
    }

    @GetMapping("/name/{expr}")
    List<City> getAllByName(@PathVariable String  expr){
        return service.readAllByName(expr);
    }

    @GetMapping("/capitals")
    List<City> getAllCapitals(){
        return service.readAllCapitals();
    }
    @PostMapping("/create")
    City create(@RequestBody City city){
        return service.create(city);
    }
    @PostMapping("/update")
    City update(@RequestBody City city){
        return service.update(city);
    }
}
