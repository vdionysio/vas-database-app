package com.ecoveco.VasDatabaseApp.repository;

import com.ecoveco.VasDatabaseApp.entity.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalRepository extends JpaRepository<Locality, Long> {

    List<Locality> findByCityId(Long cityId);
}
