package com.ecoveco.VasDatabaseApp.repository;

import com.ecoveco.VasDatabaseApp.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Long> {
    List<Position> findByLocalityId(Long localityId);
}
