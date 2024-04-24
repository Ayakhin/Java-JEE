package com.hitema.intro.services;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CityServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(CityServiceImplTest.class);
    @Autowired
    CityService service;
    @Test
    void readAllCapitals() {
        service.readAllCapitals().forEach(c->log.trace("{}", c));
    }
}