package com.ecoveco.VasDatabaseApp.service;

import com.ecoveco.VasDatabaseApp.dto.LocalDTO;
import com.ecoveco.VasDatabaseApp.dto.LocalFormDTO;
import com.ecoveco.VasDatabaseApp.entity.City;
import com.ecoveco.VasDatabaseApp.entity.Local;
import com.ecoveco.VasDatabaseApp.exception.ResourceNotFoundException;
import com.ecoveco.VasDatabaseApp.mapper.LocalMapper;
import com.ecoveco.VasDatabaseApp.repository.CityRepository;
import com.ecoveco.VasDatabaseApp.repository.LocalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocalService {
    private LocalRepository localRepository;
    private CityRepository cityRepository;
    private LocalMapper localMapper;

    public LocalService(LocalRepository localRepository, LocalMapper localMapper, CityRepository cityRepository) {
        this.localRepository = localRepository;
        this.localMapper = localMapper;
        this.cityRepository = cityRepository;
    }

    public List<LocalDTO> getByCity(Long cityId) {
        return localRepository.findByCityId(cityId).stream().map(localMapper::toDTO).collect(Collectors.toList());
    }

    public void addLocal(LocalFormDTO localDto) {
        Optional<City> city = cityRepository.findById(localDto.getCityId());

        if (city.isEmpty()) {
            throw new ResourceNotFoundException("city with id " + localDto.getCityId() + " does not exists");
        }

        localRepository.save(new Local(localDto.getName(), city.get()));
    }

    public void deleteLocal(Long localId) {
        if(!localRepository.existsById(localId)) {
            throw new ResourceNotFoundException("local with id " + localId + " does not exists");
        }
        localRepository.deleteById(localId);
    }

    public void editLocal(Long localId, LocalFormDTO updatedInfo) {
        Optional<Local> local = localRepository.findById(localId);
        if(local.isEmpty()) {
            throw new ResourceNotFoundException("local with id " + localId + " does not exists");
        }
        updateLocalUsingDto(local.get(), updatedInfo);
        localRepository.save(local.get());
    }

    public void updateLocalUsingDto(Local local, LocalFormDTO updatedInfo) {
        Optional<City> updatedCityId = cityRepository.findById(updatedInfo.getCityId());
        if(updatedCityId.isEmpty()) {
            throw new ResourceNotFoundException("city with id " + updatedInfo.getCityId() + " does not exists");
        }
        local.setCity(updatedCityId.get());
        local.setName(updatedInfo.getName());
    }
}
