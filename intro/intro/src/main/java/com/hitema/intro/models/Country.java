package com.hitema.intro.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;
import java.util.List;

@Entity
    @Table(name = "country")
public class Country {
    @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
            @Column(name="country_id")
    private Long id;

    @Column(name="country")
    private String name;


    @OneToMany(mappedBy = "country")
        @JsonIgnoreProperties(value = { "country" })
    private List<City> cities;


    @Column(name="last_update")
    private LocalDateTime lastUpdate;

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
