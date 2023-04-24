package com.ecoveco.VasDatabaseApp.repository;

import com.ecoveco.VasDatabaseApp.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByStateUf(String uf);
}
