package com.ecoveco.VasDatabaseApp.service;

import com.ecoveco.VasDatabaseApp.dto.LocalityDTO;
import com.ecoveco.VasDatabaseApp.dto.LocalityFormDTO;
import com.ecoveco.VasDatabaseApp.entity.City;
import com.ecoveco.VasDatabaseApp.entity.Locality;
import com.ecoveco.VasDatabaseApp.exception.ResourceNotFoundException;
import com.ecoveco.VasDatabaseApp.mapper.LocalityMapper;
import com.ecoveco.VasDatabaseApp.repository.CityRepository;
import com.ecoveco.VasDatabaseApp.repository.LocalityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocalityService {
    private LocalityRepository localityRepository;
    private CityRepository cityRepository;
    private LocalityMapper localityMapper;

    public LocalityService(LocalityRepository localityRepository, LocalityMapper localityMapper, CityRepository cityRepository) {
        this.localityRepository = localityRepository;
        this.localityMapper = localityMapper;
        this.cityRepository = cityRepository;
    }

    public List<LocalityDTO> getByCityId(Long cityId) {
        return localityRepository.findByCityId(cityId).stream().map(localityMapper::toDTO).collect(Collectors.toList());
    }

    public void addLocality(LocalityFormDTO localityDto) {
        Optional<City> city = cityRepository.findById(localityDto.getCityId());

        if (city.isEmpty()) {
            throw new ResourceNotFoundException("city with id " + localityDto.getCityId() + " does not exists");
        }

        localityRepository.save(new Locality(localityDto.getName(), city.get()));
    }

    public void deleteLocality(Long localityId) {
        if(!localityRepository.existsById(localityId)) {
            throw new ResourceNotFoundException("locality with id " + localityId + " does not exists");
        }
        localityRepository.deleteById(localityId);
    }

    public void editLocality(Long localityId, LocalityFormDTO updatedInfo) {
        Optional<Locality> locality = localityRepository.findById(localityId);
        if(locality.isEmpty()) {
            throw new ResourceNotFoundException("locality with id " + localityId + " does not exists");
        }
        updateLocalityUsingDto(locality.get(), updatedInfo);
        localityRepository.save(locality.get());
    }

    public void updateLocalityUsingDto(Locality locality, LocalityFormDTO updatedInfo) {
        Optional<City> updatedCityId = cityRepository.findById(updatedInfo.getCityId());
        if(updatedCityId.isEmpty()) {
            throw new ResourceNotFoundException("city with id " + updatedInfo.getCityId() + " does not exists");
        }
        locality.setCity(updatedCityId.get());
        locality.setName(updatedInfo.getName());
    }
}
