package com.ecoveco.VasDatabaseApp.repository;

import com.ecoveco.VasDatabaseApp.entity.City;
import com.ecoveco.VasDatabaseApp.entity.Locality;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class LocalityRepositoryTest {

    private LocalRepository underTest;
    private CityRepository cityRepository;

    @Autowired
    public LocalityRepositoryTest(LocalRepository underTest, CityRepository cityRepository) {
        this.underTest = underTest;
        this.cityRepository = cityRepository;
    }

    @BeforeEach
    void setUp() {
        City city = cityRepository.findById(4950L).get();
        Locality locality1 = new Locality("Saco da Quitéria", city);
        Locality locality2 = new Locality("Saco do Justino", city);
        underTest.saveAll(Arrays.asList(locality1, locality2));
    }

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    @DisplayName("Find by City ID successfully")
    void testFindByValidCityId() {
        // when
        List<Locality> localities = underTest.findByCityId(4950L);

        // then
        assertThat(localities).hasSize(2);

    }

}