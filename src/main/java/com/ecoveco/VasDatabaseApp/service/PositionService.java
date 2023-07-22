package com.ecoveco.VasDatabaseApp.service;

import com.ecoveco.VasDatabaseApp.dto.PositionDTO;
import com.ecoveco.VasDatabaseApp.dto.PositionFormDTO;
import com.ecoveco.VasDatabaseApp.entity.Locality;
import com.ecoveco.VasDatabaseApp.entity.Position;
import com.ecoveco.VasDatabaseApp.exception.ResourceNotFoundException;
import com.ecoveco.VasDatabaseApp.mapper.PositionMapper;
import com.ecoveco.VasDatabaseApp.repository.LocalityRepository;
import com.ecoveco.VasDatabaseApp.repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PositionService {
    private PositionRepository positionRepository;
    private LocalityRepository localityRepository;

    private PositionMapper positionMapper;

    public PositionService(PositionRepository positionRepository, LocalityRepository localityRepository, PositionMapper positionMapper) {
        this.positionRepository = positionRepository;
        this.localityRepository = localityRepository;
        this.positionMapper = positionMapper;
    }

    public List<PositionDTO> getByLocalityId(Long localityId) {
        return positionRepository.findByLocalityId(localityId).stream().map(positionMapper::toDto).collect(Collectors.toList());
    }

    public void add(PositionFormDTO position) {
        Optional<Locality> locality = localityRepository.findById(position.getLocalityId());

        if (locality.isEmpty()) {
            throw new ResourceNotFoundException("locality with id " + position.getLocalityId() + " does not exists");
        }

        positionRepository.save(new Position(position.getTransect(), position.getPoint(), position.getLatitude(), position.getLongitude(), position.getNotes(), locality.get()));
    }
}
