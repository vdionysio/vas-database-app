package com.ecoveco.VasDatabaseApp.repository;

import com.ecoveco.VasDatabaseApp.entity.City;
import com.ecoveco.VasDatabaseApp.entity.Local;
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
class LocalRepositoryTest {

    private LocalRepository underTest;
    private CityRepository cityRepository;

    @Autowired
    public LocalRepositoryTest(LocalRepository underTest, CityRepository cityRepository) {
        this.underTest = underTest;
        this.cityRepository = cityRepository;
    }

    @BeforeEach
    void setUp() {
        City city = cityRepository.findById(4950L).get();
        Local local1 = new Local("Saco da Quitéria", city);
        Local local2 = new Local("Saco do Justino", city);
        underTest.saveAll(Arrays.asList(local1, local2));
    }

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    @DisplayName("Find by City ID successfully")
    void testFindByValidCityId() {
        // when
        List<Local> locals = underTest.findByCityId(4950L);

        // then
        assertThat(locals).hasSize(2);

    }

}