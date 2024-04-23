package com.hitema.intro.services;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CountryServiceTest {

    private static final Logger log = LoggerFactory.getLogger(CountryServiceTest.class);
    @Autowired
    CountryService service;

    @Test
    void create() {
    }

    @Test
    void read() {
        log.info("DEBUT TESTS Read One");
        Long id = 6l;
        var country = service.read(id);
        log.trace("{}", country);
        log.info("FIN TESTS Read One");
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void readAll() {
        log.info("DEBUT TESTS");
        service.readAll().forEach(c-> log.trace("{}",c));
        log.error("<<<ERROR>>>");
        log.info("FIN TESTS");
    }
}