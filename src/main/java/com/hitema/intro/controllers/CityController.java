package com.hitema.intro.controllers;

import com.hitema.intro.models.City;
import com.hitema.intro.services.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City city) {
        City createdCity = cityService.create(city);
        return new ResponseEntity<>(createdCity, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        City city = cityService.read(id);
        return city != null ? ResponseEntity.ok(city) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = cityService.readAll();
        return ResponseEntity.ok(cities);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City city) {
        if (cityService.read(id) == null) {
            return ResponseEntity.notFound().build();
        }
        city.setId(id);
        City updatedCity = cityService.update(city);
        return ResponseEntity.ok(updatedCity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        if (cityService.read(id) == null) {
            return ResponseEntity.notFound().build();
        }
        cityService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
