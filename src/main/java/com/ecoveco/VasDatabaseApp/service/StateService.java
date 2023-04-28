package com.ecoveco.VasDatabaseApp.service;

import com.ecoveco.VasDatabaseApp.dto.StateDTO;
import com.ecoveco.VasDatabaseApp.mapper.StateMapper;
import com.ecoveco.VasDatabaseApp.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateService {
    private StateRepository stateRepository;
    private StateMapper stateMapper;

    public StateService(StateRepository stateRepository, StateMapper stateMapper) {
        this.stateRepository = stateRepository;
        this.stateMapper = stateMapper;
    }

    public List<StateDTO> getAllStates() {
        return stateRepository.findAll().stream().map(stateMapper::toDTO).collect(Collectors.toList());
    }
}
