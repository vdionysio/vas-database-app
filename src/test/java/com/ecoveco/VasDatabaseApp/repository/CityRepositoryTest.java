package com.ecoveco.VasDatabaseApp.repository;

import com.ecoveco.VasDatabaseApp.entity.City;
import com.ecoveco.VasDatabaseApp.entity.State;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CityRepositoryTest {

    private CityRepository underTest;

    @Autowired
    public CityRepositoryTest(CityRepository underTest) {
        this.underTest = underTest;
    }

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    @DisplayName("Find by UF successfully")
    void testFindCityByValidUf() {
        // when
        List<City> spCities = underTest.findByStateUf("SP");

        // then
        assertThat(spCities).hasSize(645);

    }
}