package com.hitema.intro.services;

import com.hitema.intro.models.Country;

import java.util.List;

/**
 * Interface CRUD sur les Country
 */
public interface CountryService {
    // C reate
    Country create(Country country) ;
    // R read
    Country read(Long id);

    // U pdate
    Country update(Country country) ;
    // D elete
    boolean delete(Long id);

    List<Country> readAll() ;

}
